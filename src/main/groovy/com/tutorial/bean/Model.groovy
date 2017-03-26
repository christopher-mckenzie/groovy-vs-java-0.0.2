package com.tutorial.bean

/**
 * Created by cmcke on 3/26/2017.
 */
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

    String toString() {
        return "Model{ model_id=$model_id, name=$name, source=$source, target=$target, base_model_id=$base_model_id, domain=$domain, customizable=$customizable, default_model=$default_model, owner=$owner, status=$status }";
    }
}
