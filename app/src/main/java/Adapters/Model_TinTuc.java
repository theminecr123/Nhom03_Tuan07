package Adapters;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Model_TinTuc  implements Parcelable {
    private String imageUrl;
    private String title;
    private String articleUrl;

    public Model_TinTuc(String imageUrl, String title, String articleUrl) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.articleUrl = articleUrl;
    }

    protected Model_TinTuc(Parcel in) {
        imageUrl = in.readString();
        title = in.readString();
        articleUrl = in.readString();
    }

    public static final Creator<Model_TinTuc> CREATOR = new Creator<Model_TinTuc>() {
        @Override
        public Model_TinTuc createFromParcel(Parcel in) {
            return new Model_TinTuc(in);
        }

        @Override
        public Model_TinTuc[] newArray(int size) {
            return new Model_TinTuc[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(imageUrl);
        dest.writeString(title);
        dest.writeString(articleUrl);
    }
}
