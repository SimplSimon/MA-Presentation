package com.example.mvvm_compose_w4.core.data

import com.example.mvvm_compose_w4.core.domain.DriverMessage

class DemoData {
    companion object {
        fun create(size: Int, firstName: String, familyName: String): List<DriverMessage> {
            return List(
                size = size,
                init =
                {
                    index ->
                    DriverMessage(
                        index,
                        firstName,
                        familyName,
                        "HM",
                        100
                    )
                }
            )
        }
    }
}