package az.parvin.hremployeeservice.exceptionApi;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Collection;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CollectionMessage<D extends Serializable> extends ApiMessage implements Serializable {

    static final long serialVersionUID = 7895758050945535589L;
    Collection<D> items;
}
