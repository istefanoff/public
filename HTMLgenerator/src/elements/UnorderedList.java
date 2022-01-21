package elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnorderedList extends ElementImpl implements Element {
    List<String> unorderedList;

    public UnorderedList(String id, String...listElements) {
        super.id = id;
        this.unorderedList = new ArrayList<>();
        unorderedList.addAll(Arrays.asList(listElements));
    }

    public List<String> getUnorderedList() {
        return unorderedList;
    }

    public void setUnorderedList(List<String> unorderedList) {
        this.unorderedList = unorderedList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ul id=").append(this.getId()).append("\"").append(">").append(System.lineSeparator());
        for (String s : this.getUnorderedList()) {
            sb.append("<li>").append(s).append("</li>").append(System.lineSeparator());
        }
        sb.append("</ul>");

        return sb.toString();

    }

}
