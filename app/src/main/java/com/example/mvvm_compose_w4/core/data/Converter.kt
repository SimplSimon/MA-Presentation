package com.example.mvvm_compose_w4.core.data

import com.example.mvvm_compose_w4.core.domain.DriverMessage

class Converter {
    fun convertApiModelToDriverMessages(original: ApiModel?): List<DriverMessage> {
        val driverList: MutableList<DriverMessage> = mutableListOf()
        if (original != null) {
            original.mRData?.standingsTable?.standingsLists?.forEach { listsItem ->
                listsItem?.driverStandings?.forEach {
                    if (it != null) {
                        driverList.add(
                            DriverMessage(
                                position = it.position?.toInt() ?: 0,
                                givenName = it.driver?.givenName!!,
                                familyName = it.driver.familyName!!,
                                team = it.constructors?.get(0)?.constructorId!!,
                                points = it.points!!.toInt()
                            )
                        )
                    }
                }
            }
        }
        return driverList
    }
}