package com.pocbeagle.bff.components

import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.widget.action.*
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.ScrollView
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.Text
import com.pocbeagle.bff.Data.YearData

class ScreenComponentIntro {

    fun getIntroComponent(
    ): Container {
        return Container(
                context = ContextData(
                        id = "myContext",
                        value = YearData(
                                text = ""
                        )),
                children = listOf(

                        createButton(),
                        makeContainersList()
                ))
    }

    fun createButton(): Button {
        return Button(
                text = "Curiosity by year",
                onPress = listOf(
                        SendRequest(
                                url = "http://numbersapi.com/random/year",
                                method = RequestActionMethod.GET,
                                onSuccess = listOf(
                                        SetContext(
                                                contextId = "myContext",
                                                path = "yearData",
                                                value = listOf(
                                                        YearData(
                                                                text = "@{onSuccess.data.results.text}"


                                                        )
                                                )
                                        )))))

    }


    fun makeContainersList(): Container {
                   return Container(
                            children = listOf(
                                    Text(
                                            text = "@{myContext.YearData.text}"

                                    ).applyStyle(
                                            Style(
                                                    padding = EdgeValue(all = 3.unitPercent())
                                            )
                                    )
                            )

                    ).applyStyle(
                            Style(
                                    backgroundColor = "#363636",
                                    margin = EdgeValue(all = 2.unitPercent())
                            )
                    )
        }
}

