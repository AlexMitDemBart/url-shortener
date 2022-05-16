package azo.developer.urlshortener.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "url")
public class UrlEntity {
    private Long id;
    private String realUrl;
    private String shortUrl;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "real_url")
    public String getRealUrl() {
        return realUrl;
    }

    public void setRealUrl(String realUrl) {
        this.realUrl = realUrl;
    }

    @Basic
    @Column(name = "short_url")
    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UrlEntity urlEntity = (UrlEntity) o;

        if (id != urlEntity.id) return false;
        if (!Objects.equals(realUrl, urlEntity.realUrl)) return false;
        if (!Objects.equals(shortUrl, urlEntity.shortUrl)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (realUrl != null ? realUrl.hashCode() : 0);
        result = 31 * result + (shortUrl != null ? shortUrl.hashCode() : 0);
        return result;
    }
}
