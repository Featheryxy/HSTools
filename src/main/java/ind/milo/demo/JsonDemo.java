package ind.milo.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import ind.milo.entity.TaskItem;

import java.util.List;

public class JsonDemo {
    private static String mdf = "{\"code\":\"200\",\"message\":\"success\",\"data\":{\"items\":[{\"operator_code\":null,\"user_no\":null,\"user_real_name\":null,\"user_token\":null,\"cur_rights_group\":null,\"creator_name\":\"石遵明\",\"creator_id\":\"shizm21605\",\"create_time\":\"2022-09-27 10:00:05\",\"update_time\":\"2022-09-27 10:00:05\",\"filed_value\":null,\"filed_value_dtolist\":null,\"id\":9999022,\"name\":\"「开发」【产品行情管理】产品行情管理下面两个子页面 净值维护、行情维护，增加查询条件。 产品类型：净值 固收\",\"priority\":3,\"priority_name\":\"中\",\"status\":0,\"status_name\":\"待启动\",\"sub_status\":0,\"sub_status_name\":\"待启动\",\"task_type\":2,\"task_type_name\":\"开发\",\"sprint_name\":\"TA6.0V202202.01.013\",\"sprint_version\":\"TA6.0V202202.01.013\",\"git_review\":null,\"project_manager_id\":\"wanghz09413\",\"status_update_time\":null,\"project_id\":200000195,\"project_name\":\"HUNDSUN信托登记过户系统软件V6.0\",\"project_no\":\"20220512\",\"product_name\":\"HUNDSUN信托登记过户系统软件V6.0\",\"product_no\":\"CP-S001521-6.0\",\"product_id\":\"4000543\",\"estimate_workload\":4.0,\"estimate_start_time\":null,\"estimate_finish_time\":\"2022-10-14 23:59:59\",\"assignee_id\":\"yexy34716\",\"assignee_name\":\"叶相宇\",\"distributor_id\":\"shizm21605\",\"distributor_name\":\"石遵明\",\"patch_nums\":null,\"real_workload\":null,\"real_finish_time\":null,\"finish_percentage\":0.0000,\"story_number\":null,\"story_numbers\":\"202209213329\",\"pre_task\":9999012,\"pre_task_name\":null,\"available_status\":null,\"expired_information\":null,\"task_number\":\"T202209273534\",\"cancel_reason\":null,\"deadline\":null,\"sprint_id\":4629884,\"milestone_ap_id\":null,\"task_source\":1,\"task_source_name\":\"需求\",\"risk_status\":null,\"risk_id\":null,\"risk_name\":null,\"copy_to\":null,\"copy_to_list\":null,\"application_ids\":null,\"application_names\":null,\"suggestion\":null,\"remark\":null,\"task_remark\":null,\"excutor_id\":null,\"excutor_name\":null,\"description\":\"<p>【产品行情管理】</p><p>产品行情管理下面两个子页面 净值维护、行情维护，增加查询条件。&nbsp;</p><p>产品类型：净值 固收 货币</p><p>项目部门：目前已经存在的部门信息</p><br><p>尊敬的客户您好！</p><p>【需求背景】&nbsp;</p><p>【场景描述】</p><p>【处理意见】</p><p>优化需求，与贵司需求【202209134472】内部部分重复，此处仅新增部门信息查询即可，经沟通，查询条件使用产品发行部门，而非项目部门。</p><p>【周边接口】</p><p>【权限脱敏】</p><p>【历史数据】</p><p>产品行情管理下面两个子页面 净值维护、行情维护，增加查询条件：产品发行部门<br></p>\",\"edit_description\":null,\"modified_file\":null,\"branch\":null,\"test_record_id\":7933238,\"test_workload\":null,\"zip_package_path\":null,\"integration_desc\":null,\"app_versions\":null,\"app_version_names\":null,\"integrate_type\":0,\"review_mark\":1,\"reviewer_id\":\"shizm21605\",\"reviewer_name\":\"石遵明\",\"review_result\":null,\"expire_mark\":null,\"relation_dtolist\":[{\"story_id\":6404520,\"story_name\":null,\"story_number\":\"202209213329\",\"story_description\":null,\"story_version_status\":24,\"product_name\":null,\"story_type\":null,\"story_type_name\":null,\"module_id\":null,\"module_name\":null,\"jira_id\":null}],\"patch_num_list\":null,\"dev_integrate_branch\":null,\"test_integrate_branch\":null,\"format_code\":false,\"use_dev_pipeline\":false,\"use_test_pipeline\":false,\"integrate_success_time\":0,\"integrate_fail_time\":0,\"use_wait_to_test\":false,\"is_review\":null,\"reviewer\":null,\"review_people_name\":null,\"review_finish_time\":null,\"review_remark\":null,\"review_member_list\":[],\"story_version_status\":null,\"overdue_mark\":null,\"sprint_status\":1,\"test_return_number\":0,\"test_back_number\":0,\"test_result\":null,\"jira_id\":null,\"case_writer_id\":null,\"case_writer_name\":null,\"require_case_finish_time\":null,\"no_code_submission\":null,\"need_test\":null,\"real_test_finish_time\":null,\"real_test_workload\":null,\"require_finish_time\":null,\"test_package_name\":null,\"operate_bill\":null,\"release_version\":null,\"module_name\":null,\"first_integrate_time\":null,\"last_integrate_time\":null,\"last_integrate_man_no\":null,\"last_integrate_man_name\":null,\"assign_dev_mark\":0,\"task_response_id\":null,\"task_response_name\":null,\"team_name\":null,\"audit_description\":null,\"cancel_reason_type\":null,\"generated_workload\":null,\"modify_summary\":null,\"test_type\":\"1\",\"test_back_reason\":null,\"test_method\":null,\"design_description\":null,\"customers\":\"67379\",\"customer_names\":\"华鑫国际信托有限公司\",\"real_start_time\":null,\"promise_dates\":\"2022-10-31\",\"relation_task_list\":null,\"from_jira\":0,\"test_content\":null,\"release_status\":1,\"table_modify\":null,\"switch_menu_config\":null,\"compatible_desc\":null,\"publish_desc\":null,\"out_program\":null},{\"operator_code\":null,\"user_no\":null,\"user_real_name\":null,\"user_token\":null,\"cur_rights_group\":null,\"creator_name\":\"石遵明\",\"creator_id\":\"shizm21605\",\"create_time\":\"2022-09-06 14:11:48\",\"update_time\":\"2022-09-28 15:07:15\",\"filed_value\":null,\"filed_value_dtolist\":null,\"id\":9925669,\"name\":\"「开发」【百瑞信托】估值系统将所有产品净值全部推送给TA，包括部分未在恒生TA里运行的产品，净值同步时需要进行过滤，只取在TA系统中运行的产品\",\"priority\":2,\"priority_name\":\"高\",\"status\":0,\"status_name\":\"待启动\",\"sub_status\":0,\"sub_status_name\":\"待启动\",\"task_type\":2,\"task_type_name\":\"开发\",\"sprint_name\":\"TA6.0V202202.03.009\",\"sprint_version\":\"TA6.0V202202.03.009\",\"git_review\":null,\"project_manager_id\":\"wanghz09413\",\"status_update_time\":null,\"project_id\":200000195,\"project_name\":\"HUNDSUN信托登记过户系统软件V6.0\",\"project_no\":\"20220512\",\"product_name\":\"HUNDSUN信托登记过户系统软件V6.0\",\"product_no\":\"CP-S001521-6.0\",\"product_id\":\"4000543\",\"estimate_workload\":8.0,\"estimate_start_time\":\"2022-09-06 23:59:59\",\"estimate_finish_time\":\"2022-09-19 23:59:59\",\"assignee_id\":\"yexy34716\",\"assignee_name\":\"叶相宇\",\"distributor_id\":\"shizm21605\",\"distributor_name\":\"石遵明\",\"patch_nums\":null,\"real_workload\":null,\"real_finish_time\":null,\"finish_percentage\":0.0000,\"story_number\":null,\"story_numbers\":\"202208255385\",\"pre_task\":9925666,\"pre_task_name\":null,\"available_status\":null,\"expired_information\":\"超期10天\",\"task_number\":\"T202209064721\",\"cancel_reason\":null,\"deadline\":\"2022年09月19日截止\",\"sprint_id\":4654824,\"milestone_ap_id\":null,\"task_source\":1,\"task_source_name\":\"需求\",\"risk_status\":null,\"risk_id\":null,\"risk_name\":null,\"copy_to\":null,\"copy_to_list\":null,\"application_ids\":null,\"application_names\":null,\"suggestion\":null,\"remark\":null,\"task_remark\":null,\"excutor_id\":null,\"excutor_name\":null,\"description\":\"<p>1、从净值中间表向净值正式表同步数据时， 只同步TA存在的产品， （百瑞估值系统会向中间表插入TA不存在的产品）</p><p>2、校验是否同步完成时，也只校验TA存在的产品</p>\",\"edit_description\":null,\"modified_file\":null,\"branch\":null,\"test_record_id\":7874067,\"test_workload\":null,\"zip_package_path\":null,\"integration_desc\":null,\"app_versions\":null,\"app_version_names\":null,\"integrate_type\":0,\"review_mark\":1,\"reviewer_id\":\"shizm21605\",\"reviewer_name\":\"石遵明\",\"review_result\":null,\"expire_mark\":1,\"relation_dtolist\":[{\"story_id\":6364842,\"story_name\":null,\"story_number\":\"202208255385\",\"story_description\":null,\"story_version_status\":24,\"product_name\":null,\"story_type\":null,\"story_type_name\":null,\"module_id\":null,\"module_name\":null,\"jira_id\":null}],\"patch_num_list\":null,\"dev_integrate_branch\":null,\"test_integrate_branch\":null,\"format_code\":false,\"use_dev_pipeline\":false,\"use_test_pipeline\":false,\"integrate_success_time\":0,\"integrate_fail_time\":0,\"use_wait_to_test\":false,\"is_review\":null,\"reviewer\":null,\"review_people_name\":null,\"review_finish_time\":null,\"review_remark\":null,\"review_member_list\":[],\"story_version_status\":null,\"overdue_mark\":null,\"sprint_status\":1,\"test_return_number\":0,\"test_back_number\":0,\"test_result\":null,\"jira_id\":null,\"case_writer_id\":null,\"case_writer_name\":null,\"require_case_finish_time\":null,\"no_code_submission\":null,\"need_test\":null,\"real_test_finish_time\":null,\"real_test_workload\":null,\"require_finish_time\":null,\"test_package_name\":null,\"operate_bill\":null,\"release_version\":null,\"module_name\":null,\"first_integrate_time\":null,\"last_integrate_time\":null,\"last_integrate_man_no\":null,\"last_integrate_man_name\":null,\"assign_dev_mark\":0,\"task_response_id\":null,\"task_response_name\":null,\"team_name\":null,\"audit_description\":null,\"cancel_reason_type\":null,\"generated_workload\":null,\"modify_summary\":null,\"test_type\":\"1\",\"test_back_reason\":null,\"test_method\":null,\"design_description\":null,\"customers\":\"86769\",\"customer_names\":\"百瑞信托有限责任公司\",\"real_start_time\":null,\"promise_dates\":\"2022-09-30\",\"relation_task_list\":null,\"from_jira\":0,\"test_content\":null,\"release_status\":1,\"table_modify\":null,\"switch_menu_config\":null,\"compatible_desc\":null,\"publish_desc\":null,\"out_program\":null},{\"operator_code\":null,\"user_no\":null,\"user_real_name\":null,\"user_token\":null,\"cur_rights_group\":null,\"creator_name\":\"石遵明\",\"creator_id\":\"shizm21605\",\"create_time\":\"2022-09-19 09:23:33\",\"update_time\":\"2022-09-19 09:23:33\",\"filed_value\":null,\"filed_value_dtolist\":null,\"id\":9964091,\"name\":\"「开发」【百瑞信托】估值系统将所有产品净值全部推送给TA，包括部分未在恒生TA里运行的产品，净值同步时需要进行过滤，只取在TA系统中运行的产品\",\"priority\":2,\"priority_name\":\"高\",\"status\":0,\"status_name\":\"待启动\",\"sub_status\":0,\"sub_status_name\":\"待启动\",\"task_type\":2,\"task_type_name\":\"开发\",\"sprint_name\":\"TA6.0V202202.03.006M3\",\"sprint_version\":\"TA6.0V202202.03.006M3\",\"git_review\":null,\"project_manager_id\":\"wanghz09413\",\"status_update_time\":null,\"project_id\":200000195,\"project_name\":\"HUNDSUN信托登记过户系统软件V6.0\",\"project_no\":\"20220512\",\"product_name\":\"HUNDSUN信托登记过户系统软件V6.0\",\"product_no\":\"CP-S001521-6.0\",\"product_id\":\"4000543\",\"estimate_workload\":8.0,\"estimate_start_time\":null,\"estimate_finish_time\":\"2022-09-23 23:59:59\",\"assignee_id\":\"yexy34716\",\"assignee_name\":\"叶相宇\",\"distributor_id\":\"shizm21605\",\"distributor_name\":\"石遵明\",\"patch_nums\":null,\"real_workload\":null,\"real_finish_time\":null,\"finish_percentage\":0.0000,\"story_number\":null,\"story_numbers\":\"202208255385\",\"pre_task\":null,\"pre_task_name\":null,\"available_status\":null,\"expired_information\":\"超期6天\",\"task_number\":\"T202209193239\",\"cancel_reason\":null,\"deadline\":\"2022年09月23日截止\",\"sprint_id\":4654797,\"milestone_ap_id\":null,\"task_source\":1,\"task_source_name\":\"需求\",\"risk_status\":null,\"risk_id\":null,\"risk_name\":null,\"copy_to\":null,\"copy_to_list\":null,\"application_ids\":null,\"application_names\":null,\"suggestion\":null,\"remark\":null,\"task_remark\":\"\",\"excutor_id\":null,\"excutor_name\":null,\"description\":\"<p>估值系统将所有产品净值全部推送给TA，包括部分未在恒生TA里运行的产品，净值同步时需要进行过滤，只取在TA系统中运行的产品</p><br><p>估值系统中同时存在恒生TA和盈丰TA的项目，在估值净值接口导致时，会导出所有产品，恒生TA获取净值时，仅获取恒生TA的产品即可，确保获取时不要报错</p>\",\"edit_description\":null,\"modified_file\":null,\"branch\":\"\",\"test_record_id\":7905458,\"test_workload\":null,\"zip_package_path\":null,\"integration_desc\":null,\"app_versions\":null,\"app_version_names\":null,\"integrate_type\":0,\"review_mark\":0,\"reviewer_id\":\"\",\"reviewer_name\":\"\",\"review_result\":null,\"expire_mark\":1,\"relation_dtolist\":[{\"story_id\":6364842,\"story_name\":null,\"story_number\":\"202208255385\",\"story_description\":null,\"story_version_status\":24,\"product_name\":null,\"story_type\":null,\"story_type_name\":null,\"module_id\":null,\"module_name\":null,\"jira_id\":null}],\"patch_num_list\":null,\"dev_integrate_branch\":\"\",\"test_integrate_branch\":\"\",\"format_code\":false,\"use_dev_pipeline\":false,\"use_test_pipeline\":false,\"integrate_success_time\":0,\"integrate_fail_time\":0,\"use_wait_to_test\":false,\"is_review\":0,\"reviewer\":null,\"review_people_name\":null,\"review_finish_time\":null,\"review_remark\":\"\",\"review_member_list\":[],\"story_version_status\":null,\"overdue_mark\":null,\"sprint_status\":1,\"test_return_number\":0,\"test_back_number\":0,\"test_result\":null,\"jira_id\":null,\"case_writer_id\":null,\"case_writer_name\":null,\"require_case_finish_time\":null,\"no_code_submission\":null,\"need_test\":null,\"real_test_finish_time\":null,\"real_test_workload\":null,\"require_finish_time\":null,\"test_package_name\":null,\"operate_bill\":null,\"release_version\":null,\"module_name\":null,\"first_integrate_time\":null,\"last_integrate_time\":null,\"last_integrate_man_no\":null,\"last_integrate_man_name\":null,\"assign_dev_mark\":0,\"task_response_id\":null,\"task_response_name\":null,\"team_name\":null,\"audit_description\":null,\"cancel_reason_type\":null,\"generated_workload\":null,\"modify_summary\":null,\"test_type\":\"1\",\"test_back_reason\":null,\"test_method\":null,\"design_description\":\"\",\"customers\":\"86769\",\"customer_names\":\"百瑞信托有限责任公司\",\"real_start_time\":null,\"promise_dates\":\"2022-09-30\",\"relation_task_list\":null,\"from_jira\":0,\"test_content\":null,\"release_status\":1,\"table_modify\":null,\"switch_menu_config\":null,\"compatible_desc\":null,\"publish_desc\":null,\"out_program\":null},{\"operator_code\":null,\"user_no\":null,\"user_real_name\":null,\"user_token\":null,\"cur_rights_group\":null,\"creator_name\":\"石遵明\",\"creator_id\":\"shizm21605\",\"create_time\":\"2022-09-27 09:53:49\",\"update_time\":\"2022-09-27 09:53:49\",\"filed_value\":null,\"filed_value_dtolist\":null,\"id\":9998939,\"name\":\"「开发」【紧急】需求背景：目前FA推送到TA的净值信息，没有一个界面可以很方便的查询出来，如果有少推送的情况\",\"priority\":3,\"priority_name\":\"中\",\"status\":0,\"status_name\":\"待启动\",\"sub_status\":0,\"sub_status_name\":\"待启动\",\"task_type\":2,\"task_type_name\":\"开发\",\"sprint_name\":\"TA6.0V202202.01.013\",\"sprint_version\":\"TA6.0V202202.01.013\",\"git_review\":null,\"project_manager_id\":\"wanghz09413\",\"status_update_time\":null,\"project_id\":200000195,\"project_name\":\"HUNDSUN信托登记过户系统软件V6.0\",\"project_no\":\"20220512\",\"product_name\":\"HUNDSUN信托登记过户系统软件V6.0\",\"product_no\":\"CP-S001521-6.0\",\"product_id\":\"4000543\",\"estimate_workload\":10.0,\"estimate_start_time\":null,\"estimate_finish_time\":\"2022-10-14 23:59:59\",\"assignee_id\":\"yexy34716\",\"assignee_name\":\"叶相宇\",\"distributor_id\":\"shizm21605\",\"distributor_name\":\"石遵明\",\"patch_nums\":null,\"real_workload\":null,\"real_finish_time\":null,\"finish_percentage\":0.0000,\"story_number\":null,\"story_numbers\":\"202209134472\",\"pre_task\":9998929,\"pre_task_name\":null,\"available_status\":null,\"expired_information\":null,\"task_number\":\"T202209273469\",\"cancel_reason\":null,\"deadline\":null,\"sprint_id\":4629884,\"milestone_ap_id\":null,\"task_source\":1,\"task_source_name\":\"需求\",\"risk_status\":null,\"risk_id\":null,\"risk_name\":null,\"copy_to\":null,\"copy_to_list\":null,\"application_ids\":null,\"application_names\":null,\"suggestion\":null,\"remark\":null,\"task_remark\":null,\"excutor_id\":null,\"excutor_name\":null,\"description\":\"<p>【紧急】</p><p>需求背景：目前FA推送到TA的净值信息，没有一个界面可以很方便的查询出来，如果有少推送的情况，不能及时发现，会影响代销商，销售端净值信息展示。</p><p>需求描述：如果最新的净值（货币和净值产品）不是T-1日、则给出提醒。点击提醒链接，可以查看估值推过来的最新净值信息情况，查询条件类似净值信息查询界面，并且查询条件需要支持按照业务部门查询、最新净值日期、产品类型（货币、净值）、以及净值是否为1</p><br><p>尊敬的客户您好！</p><p>【需求背景】&nbsp;</p><p>【场景描述】</p><p>【处理意见】</p><p>经沟通，计划在产品运维-净值维护菜单，增加筛选条件，方便业务人员查看净值同步情况，对应系统改造如下：</p><p>1、菜单增加支持按照产品权限控制显示净值数据；</p><p>2、查询条件 增加是否估值日、产品属性（普通产品、货币类），是否按单位净值成交筛选条件，是否估值日配合净值日期即可查看估值已同步了哪些产品净值，未同步哪些产品净值，以便去督促估值业务人员推送净值。</p><p>3、同时将产品属性（普通产品、货币类），是否按单位净值成交条件放到产品代码放大镜查询栏中。</p><p>【周边接口】</p><p>【权限脱敏】</p><p>【历史数据】</p><p>1、菜单增加支持按照产品权限控制显示净值数据；</p><p>2、查询条件 增加是否估值日、产品属性（普通产品、货币类），是否按单位净值成交筛选条件，是否估值日配合净值日期即可查看估值已同步了哪些产品净值，未同步哪些产品净值，以便去督促估值业务人员推送净值。</p><p>3、同时将产品属性（普通产品、货币类），是否按单位净值成交条件放到产品代码放大镜查询栏中。</p>\",\"edit_description\":null,\"modified_file\":null,\"branch\":null,\"test_record_id\":7933172,\"test_workload\":null,\"zip_package_path\":null,\"integration_desc\":null,\"app_versions\":null,\"app_version_names\":null,\"integrate_type\":0,\"review_mark\":1,\"reviewer_id\":\"shizm21605\",\"reviewer_name\":\"石遵明\",\"review_result\":null,\"expire_mark\":null,\"relation_dtolist\":[{\"story_id\":6391966,\"story_name\":null,\"story_number\":\"202209134472\",\"story_description\":null,\"story_version_status\":24,\"product_name\":null,\"story_type\":null,\"story_type_name\":null,\"module_id\":null,\"module_name\":null,\"jira_id\":null}],\"patch_num_list\":null,\"dev_integrate_branch\":null,\"test_integrate_branch\":null,\"format_code\":false,\"use_dev_pipeline\":false,\"use_test_pipeline\":false,\"integrate_success_time\":0,\"integrate_fail_time\":0,\"use_wait_to_test\":false,\"is_review\":null,\"reviewer\":null,\"review_people_name\":null,\"review_finish_time\":null,\"review_remark\":null,\"review_member_list\":[],\"story_version_status\":null,\"overdue_mark\":null,\"sprint_status\":1,\"test_return_number\":0,\"test_back_number\":0,\"test_result\":null,\"jira_id\":null,\"case_writer_id\":null,\"case_writer_name\":null,\"require_case_finish_time\":null,\"no_code_submission\":null,\"need_test\":null,\"real_test_finish_time\":null,\"real_test_workload\":null,\"require_finish_time\":null,\"test_package_name\":null,\"operate_bill\":null,\"release_version\":null,\"module_name\":null,\"first_integrate_time\":null,\"last_integrate_time\":null,\"last_integrate_man_no\":null,\"last_integrate_man_name\":null,\"assign_dev_mark\":0,\"task_response_id\":null,\"task_response_name\":null,\"team_name\":null,\"audit_description\":null,\"cancel_reason_type\":null,\"generated_workload\":null,\"modify_summary\":null,\"test_type\":\"1\",\"test_back_reason\":null,\"test_method\":null,\"design_description\":null,\"customers\":\"67379\",\"customer_names\":\"华鑫国际信托有限公司\",\"real_start_time\":null,\"promise_dates\":\"2022-10-31\",\"relation_task_list\":null,\"from_jira\":0,\"test_content\":null,\"release_status\":1,\"table_modify\":null,\"switch_menu_config\":null,\"compatible_desc\":null,\"publish_desc\":null,\"out_program\":null},{\"operator_code\":null,\"user_no\":null,\"user_real_name\":null,\"user_token\":null,\"cur_rights_group\":null,\"creator_name\":\"石遵明\",\"creator_id\":\"shizm21605\",\"create_time\":\"2022-09-02 10:33:42\",\"update_time\":\"2022-09-28 13:42:44\",\"filed_value\":null,\"filed_value_dtolist\":null,\"id\":9913610,\"name\":\"「开发」【行情状态】开放周期里面的申购和赎回来更新行情状态\",\"priority\":3,\"priority_name\":\"中\",\"status\":0,\"status_name\":\"待启动\",\"sub_status\":0,\"sub_status_name\":\"待启动\",\"task_type\":2,\"task_type_name\":\"开发\",\"sprint_name\":\"TA6.0V202202.01.013\",\"sprint_version\":\"TA6.0V202202.01.013\",\"git_review\":null,\"project_manager_id\":\"wanghz09413\",\"status_update_time\":null,\"project_id\":200000195,\"project_name\":\"HUNDSUN信托登记过户系统软件V6.0\",\"project_no\":\"20220512\",\"product_name\":\"HUNDSUN信托登记过户系统软件V6.0\",\"product_no\":\"CP-S001521-6.0\",\"product_id\":\"4000543\",\"estimate_workload\":10.0,\"estimate_start_time\":\"2022-09-02 23:59:59\",\"estimate_finish_time\":\"2022-09-16 23:59:59\",\"assignee_id\":\"yexy34716\",\"assignee_name\":\"叶相宇\",\"distributor_id\":\"shizm21605\",\"distributor_name\":\"石遵明\",\"patch_nums\":null,\"real_workload\":null,\"real_finish_time\":null,\"finish_percentage\":0.0000,\"story_number\":null,\"story_numbers\":\"202208085047\",\"pre_task\":9913604,\"pre_task_name\":null,\"available_status\":null,\"expired_information\":\"超期13天\",\"task_number\":\"T202209023685\",\"cancel_reason\":null,\"deadline\":\"2022年09月16日截止\",\"sprint_id\":4629884,\"milestone_ap_id\":null,\"task_source\":1,\"task_source_name\":\"需求\",\"risk_status\":null,\"risk_id\":null,\"risk_name\":null,\"copy_to\":null,\"copy_to_list\":null,\"application_ids\":null,\"application_names\":null,\"suggestion\":null,\"remark\":null,\"task_remark\":null,\"excutor_id\":null,\"excutor_name\":null,\"description\":\"<p>根据开放周期生成行情状态时，&nbsp;</p><p>申购 对应 停止赎回</p><p>赎回 对应 停止申购</p><p>申购和赎回对应正常开放</p>\",\"edit_description\":null,\"modified_file\":null,\"branch\":null,\"test_record_id\":7864303,\"test_workload\":null,\"zip_package_path\":null,\"integration_desc\":null,\"app_versions\":null,\"app_version_names\":null,\"integrate_type\":0,\"review_mark\":1,\"reviewer_id\":\"shizm21605\",\"reviewer_name\":\"石遵明\",\"review_result\":null,\"expire_mark\":1,\"relation_dtolist\":[{\"story_id\":6335081,\"story_name\":null,\"story_number\":\"202208085047\",\"story_description\":null,\"story_version_status\":24,\"product_name\":null,\"story_type\":null,\"story_type_name\":null,\"module_id\":null,\"module_name\":null,\"jira_id\":null}],\"patch_num_list\":null,\"dev_integrate_branch\":null,\"test_integrate_branch\":null,\"format_code\":false,\"use_dev_pipeline\":false,\"use_test_pipeline\":false,\"integrate_success_time\":0,\"integrate_fail_time\":0,\"use_wait_to_test\":false,\"is_review\":null,\"reviewer\":null,\"review_people_name\":null,\"review_finish_time\":null,\"review_remark\":null,\"review_member_list\":[],\"story_version_status\":null,\"overdue_mark\":null,\"sprint_status\":1,\"test_return_number\":0,\"test_back_number\":0,\"test_result\":null,\"jira_id\":null,\"case_writer_id\":null,\"case_writer_name\":null,\"require_case_finish_time\":null,\"no_code_submission\":null,\"need_test\":null,\"real_test_finish_time\":null,\"real_test_workload\":null,\"require_finish_time\":null,\"test_package_name\":null,\"operate_bill\":null,\"release_version\":null,\"module_name\":null,\"first_integrate_time\":null,\"last_integrate_time\":null,\"last_integrate_man_no\":null,\"last_integrate_man_name\":null,\"assign_dev_mark\":0,\"task_response_id\":null,\"task_response_name\":null,\"team_name\":null,\"audit_description\":null,\"cancel_reason_type\":null,\"generated_workload\":null,\"modify_summary\":null,\"test_type\":\"1\",\"test_back_reason\":null,\"test_method\":null,\"design_description\":null,\"customers\":\"67379\",\"customer_names\":\"华鑫国际信托有限公司\",\"real_start_time\":null,\"promise_dates\":\"2022-09-30\",\"relation_task_list\":null,\"from_jira\":0,\"test_content\":null,\"release_status\":1,\"table_modify\":null,\"switch_menu_config\":null,\"compatible_desc\":null,\"publish_desc\":null,\"out_program\":null}],\"total\":5}}";
    public static void main(String[] args) {

        ParserConfig.getGlobalInstance().propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;

        String jsonArrayStr = JSONObject.parseObject(mdf).getJSONObject("data").getString("items");
//        JSON.parseObject(str, RespOrderDTO.class);
        List<TaskItem> taskItems = JSONArray.parseArray(jsonArrayStr, TaskItem.class);

        System.out.println(taskItems);



//        Object parse = ()JSON.parse(mdf);
//        System.out.println(parse);
//        JSONArray resultBOList = (JSONArray) ((JSONObject) parse).get("resultBOList");
//
//        for (Object obj : resultBOList) {
//            JSONObject jsonObj = (JSONObject) obj;
//            System.out.println("版本号："+jsonObj.get("versionNO").toString());
//            System.out.println("修改单号："+jsonObj.get("modifyNum").toString());
//            System.out.println("修改原因"+jsonObj.get("modifyReason").toString());
//            System.out.println("需求号："+jsonObj.get("reqNums").toString());
//            System.out.println("任务号："+jsonObj.get("taskNum").toString());
//            System.out.println("要求完成时间："+jsonObj.get("promiseDateStr").toString());
//            System.out.println();
//        }
    }
}