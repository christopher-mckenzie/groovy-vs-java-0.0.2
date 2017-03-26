package com.tutorial.dao

import com.tutorial.bean.Language
import com.tutorial.bean.Model
import spock.lang.Specification

/**
 * Created by cmcke on 3/26/2017.
 */
class ModelSpec extends Specification{

    def 'getModelByLanguage'(){
        given:
        Language source = new Language(language:'es', name:'Spanish')
        Language target = new Language(language:'fr', name: 'French')

        when:
        Model model = new ModelDao().getModelByLanguage source, target

        then:
        model.source == 'es'
        model.target == 'fr'
        model.model_id == 'es-fr'

    }
}
