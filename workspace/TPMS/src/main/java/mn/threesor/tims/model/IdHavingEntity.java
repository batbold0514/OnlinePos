package mn.threesor.tims.model;

import java.io.Serializable;

/**
 * IdHavingEntity. Interface.
 */

public interface IdHavingEntity <T extends Serializable> {

    T getId();

    void setId( T id );
}
