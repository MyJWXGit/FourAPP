package com.wd.circle.api;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/13 9:15
 * @change
 * @chang time
 * @class describe
 */
public interface Api {
    String LOGIN_URL="health/user/v1/login";
    String LIST_URL="health/share/knowledgeBase/v1/findDepartment";
    String LISTS_URL="health/user/sickCircle/v1/findSickCircleList";
    String SEARCH_URL="health/user/sickCircle/v1/searchSickCircle";
    String DETAILS_URL="health/user/sickCircle/v1/findSickCircleInfo";
    String COMMENT_URL="health/user/sickCircle/verify/v1/publishComment";
    String DETAILS_COMMENT_URL="health/user/sickCircle/v1/findSickCircleCommentList";
    String ADOPTION_COMMENT_URL="health/user/sickCircle/verify/v1/adoptionProposal";
    String PUT_VIEWPOINT_URL="health/user/sickCircle/verify/v1/expressOpinion";
    String CIRCLE_POST_URL="health/user/sickCircle/v1/findPatientSickCircleList";
    String MY_POST_URL="health/user/sickCircle/verify/v1/findMySickCircleList";
    String QUERY_MYCIRCLE_POST_URL="health/user/sickCircle/verify/v1/findMySickCircleCommentList";
    String PUT_CIRCLE_URL="health/user/sickCircle/verify/v1/publishSickCircle";
    String POST_IMAGE_URL="health/user/sickCircle/verify/v1/uploadSickCirclePicture";
    String DO_TASK_URL="health/user/verify/v1/doTask";
}
