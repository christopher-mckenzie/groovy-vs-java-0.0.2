This application is a sample application used for demonstrating groovy goodness within an actual real life application. This
application is a spring boot app that will call out to a few apis that ibm has supplied in order to translate a phrase from a desired language to a target language. Each api
call occurs within an individual dao. One to get possible language, another to get a model for the source and target language, and another to translate text for a model.
There are a couple endpoints setup to demonstrate this feature within an application.

Groovy techniques used:
    REST endpoint
    call api
    call api with params
    call api with params and header info
    parsing json responses
    logback.groovy sample
    @Slf4j

IBM - api documentation: https://watson-api-explorer.mybluemix.net/apis/language-translator-v2