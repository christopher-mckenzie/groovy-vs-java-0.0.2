package com.tutorial.bean

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * Created by cmcke on 3/26/2017.
 */
@ToString
@EqualsAndHashCode
class Model {
    String model_id
    String name
    String source
    String target
    String base_model_id
    String domain
    boolean customizable
    boolean default_model
    String owner
    String status

}
