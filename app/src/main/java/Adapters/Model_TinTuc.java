package Adapters;

public class Model_TinTuc {
    private String imageUrl;
    private String title;
    private String articleUrl;

    public Model_TinTuc(String imageUrl, String title, String articleUrl) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.articleUrl = articleUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }
}
