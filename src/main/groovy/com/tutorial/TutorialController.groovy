package com.tutorial

import groovy.util.logging.Slf4j
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by cmcke on 3/24/2017.
 */
@Slf4j
@RestController
class TutorialController {

    @RequestMapping('/sample1')
    def getSample(){
        log.info 'logging sample1'

        return 'foo bar'
    }

}
