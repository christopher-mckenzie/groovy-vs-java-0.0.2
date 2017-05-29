package com.tutorial.dao

import com.tutorial.bean.Language
import com.tutorial.bean.Model
import spock.lang.Specification

/**
 * Created by cmcke on 3/26/2017.
 */
class ModelSpec extends Specification{

    def 'getModelByLanguage'(){
        given: 'a source and target Language object'
        Language source = new Language(language:'es', name:'Spanish')
        Language target = new Language(language:'fr', name: 'French')

        when: 'calling to look up a model from ibm url with source and target Languages'
        Model model = new ModelDao().getModelByLanguage source, target

        then: 'model was found and matches conditions'
        model.source == 'es'
        model.target == 'fr'
        model.model_id == 'es-fr'

    }
}
