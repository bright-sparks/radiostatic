package mobi.audiogear.staticfrequency.elements.SpringboardActivity;

import android.content.Context;
import android.content.ContextWrapper;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.util.AttributeSet;
import mobi.audiogear.staticfrequency.R;
import mobi.audiogear.staticfrequency.lib.DropsourceVaried;
import mobi.audiogear.staticfrequency.activities.SpringboardActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.design.widget.TabLayout;
import mobi.audiogear.staticfrequency.fragments.KastPage;
import mobi.audiogear.staticfrequency.fragments.PlayPage;
import mobi.audiogear.staticfrequency.fragments.StudioPage;
import android.support.v4.view.ViewPager;

/**
 * The custom element class for DSPager which extends
 * {@link android.support.v4.view.ViewPager}. This element's parent page is
 * {@link mobi.audiogear.staticfrequency.activities.SpringboardActivity}.
 * This element has 13 properties: activeTabIndicatorColor, activeTabColor,
 * backgroundColor, enabled, hidden, tabBarColor, pagerType, tabLayout,
 * views, opacity, indicatorType, visibleView, tabType; and 3 children:
 * {@link mobi.audiogear.staticfrequency.elements.SpringboardActivity.DSKast},
 * {@link mobi.audiogear.staticfrequency.elements.SpringboardActivity.DSPlay},
 * {@link mobi.audiogear.staticfrequency.elements.SpringboardActivity.DSStudio}.
 */
public class DSPager extends ViewPager implements DropsourceVaried {
  /**
   * This element's current variant
   */
  private String variant;

  /**
   * The {@link FragmentManager}, used for proper inflation and management of this pager's children
   */
  FragmentManager fragmentManager;

  /**
   * Used in {@link DSPagerPagerAdapter}
   * to allow for quick dereference/referencing when destroying pages
   */
  DSPager self = this;

  /**
   * The {@link TabLayout} which holds the tabs for this pager
   */
  TabLayout tabs;

  /**
   * The title string IDs to be used in each tab in {@link #tabs}
   */
  Integer[] titles;

  /**
   * The {@link DSPagerPagerAdapter} for this pager.
   */
  public DSPagerPagerAdapter adapter;

  /**
   * {@link #DSPager(Context, AttributeSet)}
   */
  public DSPager(Context context) {
    this(context, null);
  }

  /**
   * {@link ViewPager#ViewPager(Context, AttributeSet)}
   *
   * @param context The Context the view is running in, through which it can access the current
   *                theme, resources, etc.
   * @param attrs The attributes of the XML tag that is inflating the view.
   */
  public DSPager(Context context, AttributeSet attrs) {
    super(context, attrs);

    this.setOffscreenPageLimit(2);

    this.variant = "Default";

    this.setId(R.id.pager);

    try {
      fragmentManager = ((FragmentActivity) getContext()).getSupportFragmentManager();
    } catch (ClassCastException e) {
      Log.e("DSPager", "Can't get fragment manager");
    }

    adapter = new DSPagerPagerAdapter(fragmentManager);

    this.setAdapter(adapter);

    titles = new Integer[] {R.string.kast, R.string.play, R.string.studio};
  }

  /**
   * Initializes this pager's {@link #tabs}
   */
  private void setupTabs() {
    for (int i = 0; i < titles.length; i++) {
      if (titles[i] != null && tabs.getTabAt(i) != null) tabs.getTabAt(i).setText(titles[i]);
    }
  }

  /**
   * {@link android.support.v4.view.ViewPager#onAttachedToWindow()}
   */
  @Override
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();

    this.setCurrentItem(0);

    tabs = (TabLayout) (((View) getParent()).findViewById(R.id.pager_tabs));

    tabs.setupWithViewPager(this);

    setupTabs();

    this.synchronizeStyle();

    this.addOnPageChangeListener(
        new ViewPager.SimpleOnPageChangeListener() {
          @Override
          public void onPageSelected(int position) {
            switch (position) {
              default:
                break;
            }
          }
        });
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
        {
          tabs.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.HEX_3F51B5FF));
          tabs.setSelectedTabIndicatorColor(
              ContextCompat.getColor(getContext(), R.color.HEX_FFFFFFFF));
        }
        break;
    }
  }

  /**
   * Retrieves the parent {@link SpringboardActivity} of this element.
   *
   * @return the parent {@link SpringboardActivity}
   */
  public SpringboardActivity _getParent() {
    Context context = getContext();

    while (context instanceof ContextWrapper) {
      if (context instanceof SpringboardActivity) {
        return (SpringboardActivity) context;
      }
      context = ((ContextWrapper) context).getBaseContext();
    }

    return (SpringboardActivity) context;
  }

  public class DSPagerPagerAdapter extends FragmentPagerAdapter {
    private final int NUM_ITEMS = 3;

    public DSPagerPagerAdapter(FragmentManager fragmentManager) {
      super(fragmentManager);
    }

    @Override
    public int getCount() {
      return NUM_ITEMS;
    }

    @Override
    public Fragment getItem(int position) {
      switch (position) {
        case 0:
          return new KastPage();
        case 1:
          return new PlayPage();
        case 2:
          return new StudioPage();
        default:
          return null;
      }
    }
  }
}