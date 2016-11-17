package mobi.audiogear.staticfrequency.elements.SpringboardActivity;

import android.graphics.Canvas;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.util.AttributeSet;
import mobi.audiogear.staticfrequency.R;
import mobi.audiogear.staticfrequency.lib.DropsourceVaried;
import mobi.audiogear.staticfrequency.elements.SpringboardActivity.DSPager;
import android.support.percent.PercentRelativeLayout;

/**
 * The custom element class for DSStudio which extends
 * {@link android.support.percent.PercentRelativeLayout}.
 * This element's parent page is {@link mobi.audiogear.staticfrequency.activities.SpringboardActivity},
 * and its parent element is {@link mobi.audiogear.staticfrequency.elements.SpringboardActivity.DSPager}.
 * This element has 4 properties: opacity, backgroundColor, hidden,
 * enabled; and 1 children: {@link mobi.audiogear.staticfrequency.elements.SpringboardActivity.DSStudioview}.
 */
public class DSStudio extends PercentRelativeLayout implements DropsourceVaried {
  /**
   * This element's current variant
   */
  private String variant;

  /**
   * {@link #DSStudio(Context, AttributeSet)}
   */
  public DSStudio(Context context) {
    this(context, null);
  }

  /**
   * {@link #DSStudio(Context, AttributeSet, int)}
   */
  public DSStudio(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  /**
   * {@link PercentRelativeLayout#PercentRelativeLayout(Context, AttributeSet, int)}
   *
   * @param context The Context the view is running in, through which it can access the current
   *                theme, resources, etc.
   * @param attrs The attributes of the XML tag that is inflating the view.
   * @param defStyleAttr An attribute in the current theme that contains a reference to a style resource
   *                     that supplies default values for the view. Can be 0 to not look for defaults.
   *
   */
  public DSStudio(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);

    this.variant = "Default";

    this.setId(R.id.studio);
  }

  /**
   * {@link android.support.percent.PercentRelativeLayout#onAttachedToWindow()}
   */
  @Override
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();

    this.synchronizeStyle();
  }

  /**
   * {@link android.support.percent.PercentRelativeLayout#onDraw(Canvas)}
   */
  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
  }

  /**
   * {@link DropsourceVaried#setVariant(String)}
   *
   * @param name {@link #variant}
   */
  public void setVariant(String name) {
    this.variant = name;

    synchronizeStyle();
  }

  /**
   * {@link DropsourceVaried#setState(String)}
   *
   * @param name N/A
   */
  public void setState(String name) {}

  /**
   * {@link DropsourceVaried#getState()}
   *
   * @return null
   */
  public String getState() {
    return null;
  }

  /**
   * {@link DropsourceVaried#getVariant()}
   *
   * @return {@link #variant}
   */
  public String getVariant() {
    return this.variant;
  }

  /**
   * {@link DropsourceVaried#synchronizeStyle()}
   */
  public void synchronizeStyle() {
    switch (variant) {
      case "Default":
        {}
        break;
    }
  }

  /**
   * Retrieves the parent {@link DSPager} of this element.
   *
   * @return the parent {@link DSPager}
   */
  public DSPager _getParent() {
    return (DSPager) getParent();
  }

  /**
   * This element's child studioview.
   */
  public DSStudioview _getStudioview() {
    return (DSStudioview) this.findViewById(R.id.studioview);
  }
}