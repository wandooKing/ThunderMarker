package thundermarket.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import thundermarket.domain.*;

@Component
public class PayHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Pay>> {

    @Override
    public EntityModel<Pay> process(EntityModel<Pay> model) {
        return model;
    }
}
