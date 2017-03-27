package com.tutorial.service

import com.tutorial.bean.Language
import com.tutorial.bean.Model
import com.tutorial.dao.LanguageDao
import com.tutorial.dao.ModelDao
import com.tutorial.dao.TranslateDao
import groovy.util.logging.Slf4j

/**
 * Created by cmcke on 3/26/2017.
 */
@Slf4j
class TranslateService {

     String translate(String source_language, String target_language, String text) throws RuntimeException{
         log.info "translate - request - source_language: $source_language, target_language: $target_language, text:$text"

         //retrieve possible languages then find the languages passed in -> throw exception if they are not found
         List<Language> languages = new LanguageDao().getLanguages()
         Language source = languages.find {l -> l.name == source_language}
         Language target = languages.find {l -> l.name == target_language}

         if (null == (source|| target)) {throw new RuntimeException("translate - languages not found: ${(source == null) ? 'source' : 'target'}")}

         log.info "translate - successfully languages - source:${source.language} & target:${target.language}"

         //retrieve model for languages
         Model model = new ModelDao().getModelByLanguage source, target

         if (null == model) {throw new RuntimeException("translate - model not found for: source:${source.language}, target:${target.language}")}
         log.info "translate - successfully found model for language. model: $model"

         String translated = new TranslateDao().getTranslation model, text


         if (null == translated) {throw new RuntimeException("translate - could not trasnlate for: model:${model.toString()}, text:$text")}
         log.info "translate - successfully found translation for text:$text - model_id:${model.model_id} - translated:$translated"

         return translated
    }

}
