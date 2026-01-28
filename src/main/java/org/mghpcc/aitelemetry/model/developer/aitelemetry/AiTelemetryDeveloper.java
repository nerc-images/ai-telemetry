package org.mghpcc.aitelemetry.model.developer.aitelemetry;

import org.computate.search.wrap.Wrap;
import org.mghpcc.aitelemetry.result.BaseResult;
import org.computate.vertx.config.ComputateConfigKeys;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.computate.search.tool.SearchTool;
import org.mghpcc.aitelemetry.config.ConfigKeys;
import org.mghpcc.aitelemetry.model.BaseModel;
import org.mghpcc.aitelemetry.request.SiteRequest;
import org.computate.vertx.search.list.SearchList;

import io.vertx.core.Promise;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

/**
 * Order: 4
 * Description: Learn how to become an AI Telemetry platform developer — Providing access control to observability metrics for cloud environments, ACM hubs, OpenShift Clusters, virtual machines, bare metal hardware, and cloud projects. 

 * AName: an AI Telemetry developer
 * Icon: <i class="fa-duotone fa-regular fa-chart-fft"></i>
 * Sort.asc: courseNum
 * 
 * SearchPageUri: /en-us/search/ai-telemetry-developer
 * EditPageUri: /en-us/edit/ai-telemetry-developer/{pageId}
 * UserPageUri: /en-us/ai-telemetry-developer/learn/{pageId}
 * ApiUri: /en-us/api/ai-telemetry-developer
 * ApiMethod:
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
 * 
 * AuthGroup:
 *   COMPANYPRODUCT-ai-telemetry-developer-GET:
 *     GET:
 *   Admin:
 *     POST:
 *     PATCH:
 *     GET:
 *     DELETE:
 *     Admin:
 *   SuperAdmin:
 *     POST:
 *     PATCH:
 *     GET:
 *     DELETE:
 *     SuperAdmin:
 */
public class AiTelemetryDeveloper extends AiTelemetryDeveloperGen<BaseResult> {

  /**
   * {@inheritDoc}
   */
  protected void _article(Wrap<Boolean> w) {
    w.o(true);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: course name
   * Description: The course name. 
   * HtmRow: 3
	 * HtmRowTitleOpen: course details
   * HtmCell: 1
   * HtmColumn: 0
   * Facet: true
	 * VarName: true
   */
  protected void _name(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: course description
   * Description: The course description. 
   * HtmRow: 3
   * HtmCell: 2
   * HtmColumn: 1
   * Facet: true
	 * VarDescription: true
   */
  protected void _description(Wrap<String> w) {
  }

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmRowTitleOpen: Useful URLs
	 * HtmRow: 99
	 * HtmCell: 1
	 * Facet: true
	 * DisplayName: page ID
	 * Description: The ID for this page. 
	 * VarId: true
	 */
	protected void _pageId(Wrap<String> w) {
		w.o(toId(name));
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * Facet: true
	 * DisplayName: course number
	 * Description: The course number for this page. 
	 */
	protected void _courseNum(Wrap<Integer> w) {
	}

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Facet: true
   * DisplayName: lesson number
   * Description: The lesson number for this page. 
   */
  protected void _lessonNum(Wrap<Integer> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * HtmRow: 3
   * HtmCell: 3
   * Facet: true
   * DisplayName: author name
   * Description: The author name
   */
  protected void _authorName(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * HtmRow: 3
   * HtmCell: 3
   * Facet: true
   * DisplayName: author URL
   * Description: The author URL
   */
  protected void _authorUrl(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * HtmRow: 4
   * HtmCell: 1
   * Facet: true
   * DisplayName: imageUri
   * Description: The page image URI
   */
  protected void _pageImageUri(Wrap<String> w) {
  }
  
  /**
   * DocValues: true
   * Description: The image width
   */
  protected void _pageImageWidth(Wrap<Integer> w) {
    if(pageImageUri != null) {
      Path path = Paths.get(siteRequest_.getConfig().getString(ConfigKeys.STATIC_PATH), pageImageUri);
      File file = path.toFile();
      if(file.exists()) {
        try {
          BufferedImage img = ImageIO.read(file);
          w.o(img.getWidth());
          setPageImageHeight(img.getHeight());
          setPageImageType(Files.probeContentType(path));
        } catch (Exception ex) {
          ExceptionUtils.rethrow(ex);
        }
      }
    }
  }

  /**
   * DocValues: true
   * Description: The image height
   */
  protected void _pageImageHeight(Wrap<Integer> c) {
  }

  /**
   * DocValues: true
   * Description: The image height
   */
  protected void _pageImageType(Wrap<String> c) {
  }

  /**
   * Persist: true
   * DocValues: true
   * Description: The image accessibility text. 
   */
  protected void _pageImageAlt(Wrap<String> c) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: prerequisite article IDs
   * Description: The prerequisite article IDs comma-separated. 
   */
  protected void _prerequisiteArticleIds(Wrap<String> w) {
  }

  /**
   * Ignore: true
   */
  protected void _prerequisiteArticleSearch(Promise<SearchList<AiTelemetryDeveloper>> promise) {
    SearchList<AiTelemetryDeveloper> l = new SearchList<>();
    if(prerequisiteArticleIds != null) {
      List<String> list = Arrays.asList(StringUtils.split(prerequisiteArticleIds, ",")).stream().map(id -> id.trim()).collect(Collectors.toList());
      l.setC(AiTelemetryDeveloper.class);
      l.q("*:*");
      l.fq(String.format("pageId_docvalues_string:" + list.stream()
          .map(id -> SearchTool.escapeQueryChars(id))
          .collect(Collectors.joining(" OR ", "(", ")"))
          ));
      l.setStore(true);
    }
    promise.complete(l);
  }

  /**
   * {@inheritDoc}
   * Stored: true
   * DisplayName: prerequisite articles
   * Description: A JSON array of prerequisite articles. 
   */
  protected void _prerequisiteArticles(Wrap<JsonArray> w) {
    JsonArray array = new JsonArray();
    prerequisiteArticleSearch.getList().stream().forEach(prerequisiteArticle -> {
        JsonObject obj = JsonObject.mapFrom(prerequisiteArticle);
        obj.remove(AiTelemetryDeveloper.VAR_prerequisiteArticles);
        obj.remove(AiTelemetryDeveloper.VAR_prerequisiteArticleIds);
        JsonObject obj2 = new JsonObject();
        obj2.put(AiTelemetryDeveloper.VAR_pageId, obj.getString(AiTelemetryDeveloper.VAR_pageId));
        obj2.put(AiTelemetryDeveloper.VAR_name, obj.getString(AiTelemetryDeveloper.VAR_name));
        obj2.put(AiTelemetryDeveloper.VAR_pageImageUri, obj.getString(AiTelemetryDeveloper.VAR_pageImageUri));
        obj2.put(AiTelemetryDeveloper.VAR_pageImageWidth, obj.getString(AiTelemetryDeveloper.VAR_pageImageWidth));
        obj2.put(AiTelemetryDeveloper.VAR_pageImageHeight, obj.getString(AiTelemetryDeveloper.VAR_pageImageHeight));
        obj2.put(AiTelemetryDeveloper.VAR_pageImageAlt, obj.getString(AiTelemetryDeveloper.VAR_pageImageAlt));
        obj2.put(AiTelemetryDeveloper.VAR_displayPage, obj.getString(AiTelemetryDeveloper.VAR_displayPage));
        array.add(obj2);
    });
    w.o(array);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: next article IDs
   * Description: The next article IDs comma-separated. 
   */
  protected void _nextArticleIds(Wrap<String> w) {
  }

  /**
   * Ignore: true
   */
  protected void _nextArticleSearch(Promise<SearchList<AiTelemetryDeveloper>> promise) {
    SearchList<AiTelemetryDeveloper> l = new SearchList<>();
    if(nextArticleIds != null) {
      List<String> list = Arrays.asList(StringUtils.split(nextArticleIds, ",")).stream().map(id -> id.trim()).collect(Collectors.toList());
      l.setC(AiTelemetryDeveloper.class);
      l.q("*:*");
      l.fq(String.format("pageId_docvalues_string:" + list.stream()
          .map(id -> SearchTool.escapeQueryChars(id))
          .collect(Collectors.joining(" OR ", "(", ")"))
          ));
      l.setStore(true);
    }
    promise.complete(l);
  }

  /**
   * {@inheritDoc}
   * Stored: true
   * DisplayName: next articles
   * Description: A JSON array of next articles. 
   */
  protected void _nextArticles(Wrap<JsonArray> w) {
    JsonArray array = new JsonArray();
    nextArticleSearch.getList().stream().forEach(nextArticle -> {
        JsonObject obj = JsonObject.mapFrom(nextArticle);
        obj.remove(AiTelemetryDeveloper.VAR_nextArticles);
        obj.remove(AiTelemetryDeveloper.VAR_nextArticleIds);
        JsonObject obj2 = new JsonObject();
        obj2.put(AiTelemetryDeveloper.VAR_pageId, obj.getString(AiTelemetryDeveloper.VAR_pageId));
        obj2.put(AiTelemetryDeveloper.VAR_name, obj.getString(AiTelemetryDeveloper.VAR_name));
        obj2.put(AiTelemetryDeveloper.VAR_pageImageUri, obj.getString(AiTelemetryDeveloper.VAR_pageImageUri));
        obj2.put(AiTelemetryDeveloper.VAR_pageImageWidth, obj.getString(AiTelemetryDeveloper.VAR_pageImageWidth));
        obj2.put(AiTelemetryDeveloper.VAR_pageImageHeight, obj.getString(AiTelemetryDeveloper.VAR_pageImageHeight));
        obj2.put(AiTelemetryDeveloper.VAR_pageImageAlt, obj.getString(AiTelemetryDeveloper.VAR_pageImageAlt));
        obj2.put(AiTelemetryDeveloper.VAR_displayPage, obj.getString(AiTelemetryDeveloper.VAR_displayPage));
        array.add(obj2);
    });
    w.o(array);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: labels string
   * Description: The labels String for this article comma-separated. 
   */
  protected void _labelsString(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: labels
   * Description: The labels for this article. 
   */
  protected void _labels(List<String> l) {
    if(labelsString != null) {
      l.addAll(Arrays.asList(StringUtils.split(labelsString, ",")).stream().map(id -> id.trim()).collect(Collectors.toList()));
    }
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: related article IDs
   * Description: The related article IDs comma-separated. 
   */
  protected void _relatedArticleIds(Wrap<String> w) {
  }

  /**
   * Ignore: true
   */
  protected void _relatedArticleSearch(Promise<SearchList<AiTelemetryDeveloper>> promise) {
    SearchList<AiTelemetryDeveloper> l = new SearchList<>();
    if(relatedArticleIds != null) {
      List<String> list = Arrays.asList(StringUtils.split(relatedArticleIds, ",")).stream().map(id -> id.trim()).collect(Collectors.toList());
      l.setC(AiTelemetryDeveloper.class);
      l.q("*:*");
      l.fq(String.format("pageId_docvalues_string:" + list.stream()
          .map(id -> SearchTool.escapeQueryChars(id))
          .collect(Collectors.joining(" OR ", "(", ")"))
          ));
      l.setStore(true);
    }
    promise.complete(l);
  }

  /**
   * {@inheritDoc}
   * Stored: true
   * DisplayName: related articles
   * Description: A JSON array of related articles. 
   */
  protected void _relatedArticles(Wrap<JsonArray> w) {
    JsonArray array = new JsonArray();
    relatedArticleSearch.getList().stream().forEach(relatedArticle -> {
        JsonObject obj = JsonObject.mapFrom(relatedArticle);
        obj.remove(AiTelemetryDeveloper.VAR_relatedArticles);
        obj.remove(AiTelemetryDeveloper.VAR_relatedArticleIds);
        JsonObject obj2 = new JsonObject();
        obj2.put(AiTelemetryDeveloper.VAR_pageId, obj.getString(AiTelemetryDeveloper.VAR_pageId));
        obj2.put(AiTelemetryDeveloper.VAR_name, obj.getString(AiTelemetryDeveloper.VAR_name));
        obj2.put(AiTelemetryDeveloper.VAR_pageImageUri, obj.getString(AiTelemetryDeveloper.VAR_pageImageUri));
        obj2.put(AiTelemetryDeveloper.VAR_pageImageWidth, obj.getString(AiTelemetryDeveloper.VAR_pageImageWidth));
        obj2.put(AiTelemetryDeveloper.VAR_pageImageHeight, obj.getString(AiTelemetryDeveloper.VAR_pageImageHeight));
        obj2.put(AiTelemetryDeveloper.VAR_pageImageAlt, obj.getString(AiTelemetryDeveloper.VAR_pageImageAlt));
        obj2.put(AiTelemetryDeveloper.VAR_displayPage, obj.getString(AiTelemetryDeveloper.VAR_displayPage));
        array.add(obj2);
    });
    w.o(array);
  }

  @Override
  public String enUSStringFormatUrlDisplayPageForClass() {
    return "%s/en-us/ai-telemetry-developer/learn/%s";
  }
}
