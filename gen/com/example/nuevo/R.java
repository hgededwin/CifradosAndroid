/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * aapt tool from the resource data it found.  It
 * should not be modified by hand.
 */

package com.example.nuevo;

public final class R {
    public static final class attr {
        /** <p>Must be a reference to another resource, in the form "<code>@[+][<i>package</i>:]<i>type</i>:<i>name</i></code>"
or to a theme attribute in the form "<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>".
         */
        public static final int metaButtonBarButtonStyle=0x7f010001;
        /** <p>Must be a reference to another resource, in the form "<code>@[+][<i>package</i>:]<i>type</i>:<i>name</i></code>"
or to a theme attribute in the form "<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>".
         */
        public static final int metaButtonBarStyle=0x7f010000;
    }
    public static final class color {
        public static final int black_overlay=0x7f040000;
    }
    public static final class drawable {
        public static final int ic_launcher=0x7f020000;
        public static final int rounded_btn=0x7f020001;
        public static final int rounded_btngroup=0x7f020002;
    }
    public static final class id {
        public static final int btnCifrar=0x7f07000c;
        public static final int btnDescifrar=0x7f07000b;
        public static final int lyout=0x7f070000;
        public static final int rbCesar=0x7f070006;
        public static final int rbVernam=0x7f070009;
        public static final int rbVigenere=0x7f070008;
        public static final int rbplayfair=0x7f070007;
        public static final int rdgGrupo=0x7f070005;
        public static final int textView1=0x7f070001;
        public static final int textView2=0x7f070003;
        public static final int textView3=0x7f07000d;
        public static final int txtClave=0x7f070004;
        public static final int txtResultado=0x7f07000a;
        public static final int txtTexto=0x7f070002;
    }
    public static final class layout {
        public static final int activity_main=0x7f030000;
    }
    public static final class string {
        public static final int app_name=0x7f050000;
        public static final int hello_world=0x7f050001;
    }
    public static final class style {
        /** 
        Base application theme, dependent on API level. This theme is replaced
        by AppBaseTheme from res/values-vXX/styles.xml on newer devices.
    

            Theme customizations available in newer API levels can go in
            res/values-vXX/styles.xml, while customizations related to
            backward-compatibility can go here.
        

        Base application theme for API 11+. This theme completely replaces
        AppBaseTheme from res/values/styles.xml on API 11+ devices.
    
 API 11 theme customizations can go here. 

        Base application theme for API 14+. This theme completely replaces
        AppBaseTheme from BOTH res/values/styles.xml and
        res/values-v11/styles.xml on API 14+ devices.
    
 API 14 theme customizations can go here. 
         */
        public static final int AppBaseTheme=0x7f060000;
        /**  Application theme. 
 All customizations that are NOT specific to a particular API-level can go here. 
         */
        public static final int AppTheme=0x7f060001;
    }
    public static final class styleable {
        /** 
         Declare custom theme attributes that allow changing which styles are
         used for button bars depending on the API level.
         ?android:attr/buttonBarStyle is new as of API 11 so this is
         necessary to support previous API levels.
    
           <p>Includes the following attributes:</p>
           <table>
           <colgroup align="left" />
           <colgroup align="left" />
           <tr><th>Attribute</th><th>Description</th></tr>
           <tr><td><code>{@link #ButtonBarContainerTheme_metaButtonBarButtonStyle com.example.nuevo:metaButtonBarButtonStyle}</code></td><td></td></tr>
           <tr><td><code>{@link #ButtonBarContainerTheme_metaButtonBarStyle com.example.nuevo:metaButtonBarStyle}</code></td><td></td></tr>
           </table>
           @see #ButtonBarContainerTheme_metaButtonBarButtonStyle
           @see #ButtonBarContainerTheme_metaButtonBarStyle
         */
        public static final int[] ButtonBarContainerTheme = {
            0x7f010000, 0x7f010001
        };
        /**
          <p>This symbol is the offset where the {@link com.example.nuevo.R.attr#metaButtonBarButtonStyle}
          attribute's value can be found in the {@link #ButtonBarContainerTheme} array.


          <p>Must be a reference to another resource, in the form "<code>@[+][<i>package</i>:]<i>type</i>:<i>name</i></code>"
or to a theme attribute in the form "<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>".
          @attr name com.example.nuevo:metaButtonBarButtonStyle
        */
        public static final int ButtonBarContainerTheme_metaButtonBarButtonStyle = 1;
        /**
          <p>This symbol is the offset where the {@link com.example.nuevo.R.attr#metaButtonBarStyle}
          attribute's value can be found in the {@link #ButtonBarContainerTheme} array.


          <p>Must be a reference to another resource, in the form "<code>@[+][<i>package</i>:]<i>type</i>:<i>name</i></code>"
or to a theme attribute in the form "<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>".
          @attr name com.example.nuevo:metaButtonBarStyle
        */
        public static final int ButtonBarContainerTheme_metaButtonBarStyle = 0;
    };
}
