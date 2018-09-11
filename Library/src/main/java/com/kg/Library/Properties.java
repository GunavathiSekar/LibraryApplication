package com.kg.Library;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@ConfigurationProperties(prefix = "library.books")
@Configuration
public class Properties {

    private Long morethan5;
    private Long  pointsperbook;
    private Long pointspercategory;
    private Long pointsforreview;
    private Long pointsforlike;
    private Long takenBylikerwithin3Months;
    /**
     * @return the morethan5
     */
    public Long getMorethan5() {
        return morethan5;
    }
    /**
     * @return the pointsperbook
     */
    public Long getPointsperbook() {
        return pointsperbook;
    }
    /**
     * @return the pointspercategory
     */
    public Long getPointspercategory() {
        return pointspercategory;
    }
    /**
     * @return the pointsforreview
     */
    public Long getPointsforreview() {
        return pointsforreview;
    }
    /**
     * @return the pointsforlike
     */
    public Long getPointsforlike() {
        return pointsforlike;
    }
    /**
     * @return the takenBylikerwithin3Months
     */
    public Long getTakenBylikerwithin3Months() {
        return takenBylikerwithin3Months;
    }
     /**
      * @param morethan5 the morethan5 to set
      */
     public void setMorethan5(Long morethan5) {
         this.morethan5 = morethan5;
     }
     /**
      * @param pointsforlike the pointsforlike to set
      */
     public void setPointsforlike(Long pointsforlike) {
         this.pointsforlike = pointsforlike;
     }
     /**
      * @param pointsforreview the pointsforreview to set
      */
     public void setPointsforreview(Long pointsforreview) {
         this.pointsforreview = pointsforreview;
     }
     /**
      * @param pointsperbook the pointsperbook to set
      */
     public void setPointsperbook(Long pointsperbook) {
         this.pointsperbook = pointsperbook;
     }
     /**
      * @param pointspercategory the pointspercategory to set
      */
     public void setPointspercategory(Long pointspercategory) {
         this.pointspercategory = pointspercategory;
     }
     /**
      * @param takenBylikerwithin3Months the takenBylikerwithin3Months to set
      */
     public void setTakenBylikerwithin3Months(Long takenBylikerwithin3Months) {
         this.takenBylikerwithin3Months = takenBylikerwithin3Months;
     }
}