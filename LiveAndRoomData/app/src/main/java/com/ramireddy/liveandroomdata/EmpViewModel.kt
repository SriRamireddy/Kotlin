package com.ramireddy.liveandroomdata

import com.ramireddy.liveandroomdata.db.EmpClass
import com.ramireddy.liveandroomdata.db.MyDao

class EmpViewModel(edao : MyDao) {

    val empDao = edao.getData()

    //fun insert(emp : EmpClass)
}