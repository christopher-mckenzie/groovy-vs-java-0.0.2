package com.tutorial.dao

import com.tutorial.bean.Language
import com.tutorial.bean.Model
import groovy.json.JsonSlurper
import groovy.util.logging.Slf4j

/**
 * Created by cmcke on 3/25/2017.
 */
@Slf4j
class TranslateDao {

    def base = 'https://watson-api-explorer.mybluemix.net/language-translator/api/v2/translate?'
    def params_closure = { k, p -> "$k=$p" }
    def text_encode_closure = { URLEncoder.encode(it, 'UTF-8')}

    String getTranslation(Model model, String text) {
        log.info "getTranslation request - model:$model, text:$text "
        def url = base + [model_id: model.model_id, source: model.source, target: model.target, text: text.collect(text_encode_closure).join('')].
                collect(params_closure).join('&')

        URL translation_api_url = new URL(url)
        def json = new JsonSlurper().parseText(translation_api_url.getText(requestProperties: [Accept: 'application/json'])).translations[0].translation
        log.info "getTranslation successfully translated - text: ${json.toString()}"
        return json.toString()
    }
}