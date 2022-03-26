package br.com.aondefruta.coreaondefruta

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
//import springfox.documentation.swagger2.annotations.EnableSwagger2


@SpringBootApplication
//@EnableSwagger2
class CoreAondefrutaApplication

fun main(args: Array<String>) {
	runApplication<CoreAondefrutaApplication>(*args)
}
