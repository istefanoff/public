package enums.Constants;

public enum HTMLSkeletonEnum {
    HTMLSkeleton("<!DOCTYPE html>\n" + "<html lang=\"en\">\n" + "<head>\n" + "    <meta charset=\"UTF-8\">\n" + "    <link rel=\"stylesheet\" href=\"stylesheet.css\">\n" + "    <title>Title</title>\n" + "</head>\n" + "<body>\n");

    String text;

    HTMLSkeletonEnum(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
