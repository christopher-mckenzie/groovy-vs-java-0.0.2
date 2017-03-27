package com.tutorial.dao

import com.tutorial.bean.Language
import com.tutorial.bean.Model
import groovy.json.JsonSlurper
import groovy.util.logging.Slf4j

/**
 * Created by cmcke on 3/25/2017.
 */
@Slf4j
class ModelDao {

    def base = 'https://watson-api-explorer.mybluemix.net/language-translator/api/v2/models?'

    Model getModelByLanguage(Language source, Language target){
        log.info "getModelByLanguage request - source:$source, target:$target "
        def url = base + [source: source.name, target: target.name, default:true].
                collect { k, p ->
                    "$k=$p"
                }.join('&')

        URL model_api_url = new URL(url)
        def json = new JsonSlurper().parseText(model_api_url.text)
        Model response = new Model(
                model_id: json.model_id,
                name: json.model,
                source: json.source,
                target: json.target,
                base_model_id: json.base_model_id,
                domain: json.domain,
                customizable: json.customizable,
                default_model: json.default_model,
                owner: json.owner,
                status: json.status)

        log.info "Successfully parsed getModelByLanguage(): ${response.toString()}"
        return response
    }
}
