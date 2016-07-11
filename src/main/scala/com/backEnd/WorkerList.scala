package com.backEnd

/**this case class hold the username and password
  * @param userName
  * @param password
  */

case class WorkerList (userName: String, password: String){

}

object WorkerList{
  private val workerList = DataDump.getWorkers

  def findWorker (userName: String): Array[WorkerList] ={
    def lookList (list: Array[WorkerList]): Array[WorkerList] ={
      if (list.isEmpty){
        list
      }
      else if (list.head.userName == userName){
        list
      }
      else{
        lookList(list.tail)
      }
    }
    lookList(workerList)
  }

}