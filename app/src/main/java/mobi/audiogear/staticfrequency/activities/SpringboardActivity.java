package mobi.audiogear.staticfrequency.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.content.ContextCompat;
import android.widget.LinearLayout;
import mobi.audiogear.staticfrequency.lib.DropsourceVaried;
import mobi.audiogear.staticfrequency.R;
import android.view.Window;
import android.view.WindowManager;
import mobi.audiogear.staticfrequency.elements.SpringboardActivity.*;
import mobi.audiogear.staticfrequency.dataModels.*;

/**
 * The Activity for the page: springboard. This page has the following elements:
 * pager; and the following components: .
 */
public class SpringboardActivity extends AppCompatActivity implements DropsourceVaried {
  /**
   * This page's layout container
   */
  LinearLayout springboard;

  /**
   * This page's current variant
   */
  private String variant;

  /**
   * {@link android.support.v4.app.FragmentActivity#onCreate(Bundle savedInstanceState)}
   * Will also disable the status bar, since no status bar component included.
   *
   * @param savedInstanceState If the activity is being re-initialized after previously being shut down then
   *                           this Bundle contains the data it most recently supplied in
   *                           {@link #onSaveInstanceState}. <b><i>Note: Otherwise it is null.</i></b>
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    requestWindowFeature(Window.FEATURE_NO_TITLE);

    this.getWindow()
        .setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    setContentView(R.layout.springboard);

    this.variant = "Default";

    springboard = (LinearLayout) findViewById(R.id.springboard);

    this.synchronizeStyle();
  }

  /**
   * {@link android.support.v4.app.FragmentActivity#onResume()}
   */
  @Override
  protected void onResume() {
    super.onResume();
  }

  /**
   * {@link android.support.v4.app.FragmentActivity#onStop()}
   */
  @Override
  protected void onStop() {
    super.onStop();
  }

  /**
   * Returns "this", to allow for and consistent method by which the current context
   * is accessed.
   */
  public SpringboardActivity getContext() {
    return this;
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
   * @return null since a page does not have a state
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
    switch (this.variant) {
      case "Default":
        {
          springboard.setBackgroundColor(
              ContextCompat.getColor(getContext(), R.color.HEX_434343FF));
        }
        break;
    }
  }

  /**
   * This page's child pager.
   */
  public DSPager _getPager() {
    return (DSPager) this.findViewById(R.id.pager);
  }
}