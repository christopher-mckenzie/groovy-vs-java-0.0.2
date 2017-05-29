package com.tutorial.bean

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * Created by cmcke on 3/25/2017.
 */
@ToString
@EqualsAndHashCode
class Language implements Serializable{

    String language
    String name

}
