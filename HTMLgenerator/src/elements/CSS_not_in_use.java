package elements;

import java.util.List;

public class CSS_not_in_use {
    private List<String> propertiesList;
    private String id;
    ////                CSS|random-text|background-color|blue
    ////                CSS|random-text|color|red
    ////                CSS|random-text|width|100%
    ////                CSS|random-text|text-align|center

    public CSS_not_in_use(String id, List<String> properties) {
        this.propertiesList = properties;
        this.id = id;
    }

    public List<String> getPropertiesList() {
        return this.propertiesList;
    }

    public void setPropertiesList(List<String> propertiesList) {
        this.propertiesList = propertiesList;
    }
}
