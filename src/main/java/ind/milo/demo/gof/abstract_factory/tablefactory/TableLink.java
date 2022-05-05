package ind.milo.demo.gof.abstract_factory.tablefactory;

import ind.milo.demo.gof.abstract_factory.factory.*;

public class TableLink extends Link {
    public TableLink(String caption, String url) {
        super(caption, url);
    }
    public String makeHTML() {
        return "<td><a href=\"" + url + "\">" + caption + "</a></td>\n";
    }
}
