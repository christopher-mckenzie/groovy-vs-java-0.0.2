package com.tutorial.controller

import com.tutorial.bean.Language
import com.tutorial.dao.LanguageDao
import com.tutorial.service.TranslateService
import groovy.util.logging.Slf4j
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Created by cmcke on 3/24/2017.
 */
@Slf4j
@RestController
class TutorialController {

    @RequestMapping('/languages')
    def getLanguages(){
        List<Language> languages = new LanguageDao().getLanguages()
        return "${languages.collect { element -> "</br>${element}"}}"
    }

    @RequestMapping("/translate")
    def traslate(@RequestParam('source_language') String source_language,
                 @RequestParam('target_language') String target_language,
                 @RequestParam('text') String text){
        return new TranslateService().translate(source_language, target_language, text)
    }
}
