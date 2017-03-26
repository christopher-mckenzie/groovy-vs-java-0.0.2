package com.tutorial.dao

import com.tutorial.bean.Language
import groovy.json.JsonSlurper

/**
 * Created by cmcke on 3/25/2017.
 */
class LanguageDao {

    def getLanguges(){
        URL languages_api_url = new URL('https://watson-api-explorer.mybluemix.net/language-translator/api/v2/identifiable_languages')
        def response = new JsonSlurper().parseText(languages_api_url.text) as List<Language>
        println response.toString()
    }

}
