package com.reference

import com.frontEnd.{GUIOrder, GUIOrderItems}

import scalafx.Includes._
import scalafx.application.JFXApp.PrimaryStage
import scalafx.application.{JFXApp, Platform}
import scalafx.collections.ObservableBuffer
import scalafx.event.ActionEvent
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.Alert.AlertType
import scalafx.scene.control.ButtonBar.ButtonData
import scalafx.scene.control.TableColumn._
import scalafx.scene.control._
import scalafx.scene.layout.GridPane


object GUI extends JFXApp {

  var DataList = main1.OrderListOfficial

  //creating buffer for use in GUI
  def CreateOrderbuffer (): ObservableBuffer[GUIOrder] = {

    val OrderBuffer = ObservableBuffer[GUIOrder](
    )

    for(i<- DataList){
      OrderBuffer += new GUIOrder((i).id.toString, (i).status.toString)

    }
    OrderBuffer
  }

  //creating buffer for use in GUI
  def CreateOrderItembuffer (): ObservableBuffer[GUIOrderItems] = {

    val OrderBuffer = ObservableBuffer[GUIOrderItems ](
    )

    for(i<- DataList(1).orderitems){//change 1 to specify what order you want
      OrderBuffer += new GUIOrderItems ((i).pid.toString, main1.Stock.findProduct(i.pid).get.name, (i).quantity.toString,(i). porouswareQuantity.toString)
    }
    OrderBuffer
  }
  onShowLoginDialog
  //Shows login GUI

  def onShowLoginDialog(): Unit = {

    while (!main1.valid) {
      main1.continue = false
      case class Result(username: String, password: String)

      // Create the custom dialog.
      val dialog = new Dialog[Result]() {
        initOwner(stage)
        title = "Login"
        headerText = "Please login"
        // graphic = new ImageView(this.getClass.getResource("login_icon.png").toString)
      }

      // Set the button types.
      val loginButtonType = new ButtonType("Login", ButtonData.OKDone)
      dialog.dialogPane().buttonTypes = Seq(loginButtonType, ButtonType.Cancel)

      // Create the username and password labels and fields.
      val username = new TextField() {
        promptText = "Type username here"
      }
      val password = new PasswordField() {
        promptText = "Type password here"
      }

      val grid = new GridPane() {
        hgap = 30
        vgap = 30
        padding = Insets(30, 300, 30, 30)

        add(new Label("Username:"), 0, 0)
        add(username, 1, 0)
        add(new Label("Password:"), 0, 1)
        add(password, 1, 1)
      }

      // Enable/Disable login button depending on whether a username was entered.
      val loginButton = dialog.dialogPane().lookupButton(loginButtonType)
      loginButton.disable = true

      // Do some validation (disable when username is empty).
      username.text.onChange { (_, _, newValue) => loginButton.disable = newValue.trim().isEmpty }

      dialog.dialogPane().content = grid

      // Request focus on the username field by default.
      Platform.runLater(username.requestFocus())

      // Convert the result to a username-password-pair when the login button is clicked.
      dialog.resultConverter = dialogButton =>
        if (dialogButton == loginButtonType) Result(username.text(), password.text())
        else null

      val result = dialog.showAndWait()

      result match {
        case Some(Result(user, pass)) => GUIcontinue(user, pass)
        case None => println("Dialog returned: None")
          main1.valid = true
      }

      def GUIcontinue(userr: String, passs: String): Unit = {
        var accountType = ""
        main1.checkWorker(userr, passs)

        accountType = main1.accountTypeCheck()


        if (main1.continue) {
          if (accountType == "admin") {
            new Alert(AlertType.Information, "Admin session activated").showAndWait()
            GUISessions.standard
          } else if  (accountType == "standard") {
            new Alert(AlertType.Information, "Standard session activated").showAndWait()
            GUISessions.standard
          }
        }else if (accountType != "admin" || accountType != "standard") {
          new Alert(AlertType.Error) {
            initOwner(stage)
            title = "Login"
            headerText = "Incorrect Username or password"
            contentText = "Please Try Again!"
          }.showAndWait()
        }


      }
    }//end of while
  }
  //goes to GUISession object

  //Prints OrderTable
  def PrintOrderList(): Unit = {


    stage = new PrimaryStage {
      title = "TableView with custom color cell"
      scene = new Scene {
        //gets buffer from CreateOrderbuffer method
        content = new TableView[GUIOrder](CreateOrderbuffer) {
          columns ++= List(
            new TableColumn[GUIOrder, String] {
              text = "com.backEnd.Order ID"
              cellValueFactory = {_.value.ID}
              prefWidth = 100
            },
            new TableColumn[GUIOrder, String]() {
              text = "status"
              cellValueFactory = {_.value.Status}
              prefWidth = 100
            },
            new TableColumn[GUIOrder, String] {
              text = "Login"
              cellValueFactory = {
                _.value.Status
              }
              cellFactory = { _ =>
                new TableCell[GUIOrder, String] {
                  item.onChange { (_, _, newColor) =>
                    graphic = new Button {
                      text = "Exit"
                      onAction = {
                        (e: ActionEvent) => GUISessions.standard
                      }
                    }
                  }
                }
              }
            }//column containing buttons on each row, contained within a TableCell
          )

        }

        //button here
      }
    }
  }

  def PrintOrder_items(): Unit = {

    stage = new PrimaryStage {
      title = "TableView with custom color cell"
      scene = new Scene {
        content = new TableView[GUIOrderItems](CreateOrderItembuffer) {
          columns ++= List(
            new TableColumn[GUIOrderItems, String] {
              text = "ID"
              cellValueFactory = {_.value.ID}
              prefWidth = 100
            },
            new TableColumn[GUIOrderItems, String] {
              text = "Item"
              cellValueFactory = {_.value.Item}
              prefWidth = 100
            },
            new TableColumn[GUIOrderItems, String] {
              text = "Quantity"
              cellValueFactory = {_.value.Quantity}
              prefWidth = 100
            },
            new TableColumn[GUIOrderItems, String]() {
              text = "PorousQuntuty"
              cellValueFactory = {_.value.PorousQuantity
              }
              prefWidth = 100
            }
          )
        }
      }
    }
  }
}

//test





