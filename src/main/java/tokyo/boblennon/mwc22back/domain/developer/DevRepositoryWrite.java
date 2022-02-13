package tokyo.boblennon.mwc22back.domain.developer;

import java.util.List;

public interface DevRepositoryWrite {

    public void add(Developer developer);
    public void addAll(List<Developer> devs);

}
