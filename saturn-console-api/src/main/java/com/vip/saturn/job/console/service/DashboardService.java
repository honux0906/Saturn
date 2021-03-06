package com.vip.saturn.job.console.service;

import com.vip.saturn.job.console.exception.SaturnJobConsoleException;
import com.vip.saturn.job.console.mybatis.entity.DashboardHistory;
import com.vip.saturn.job.console.mybatis.entity.SaturnStatistics;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author chembo.huang
 */
public interface DashboardService {

	int executorInDockerCount(String key) throws SaturnJobConsoleException;

	int executorNotInDockerCount(String key) throws SaturnJobConsoleException;

	int jobCount(String key) throws SaturnJobConsoleException;

	/**
	 * 失败率top10的域列表
	 */
	SaturnStatistics top10FailureDomain(String key) throws SaturnJobConsoleException;

	String top10FailureDomainByAllZkCluster() throws SaturnJobConsoleException;

	/**
	 * 根据失败率top10的作业列表
	 */
	SaturnStatistics top10FailureJob(String key) throws SaturnJobConsoleException;

	String top10FailureJobByAllZkCluster() throws SaturnJobConsoleException;

	/**
	 * 最活跃作业的作业列表(即当天执行次数最多的作业)
	 */
	SaturnStatistics top10AactiveJob(String key) throws SaturnJobConsoleException;

	String top10AactiveJobByAllZkCluster() throws SaturnJobConsoleException;

	/**
	 * 负荷最重的top10的Executor列表
	 */
	SaturnStatistics top10LoadExecutor(String key) throws SaturnJobConsoleException;

	String top10LoadExecutorByAllZkCluster() throws SaturnJobConsoleException;

	/**
	 * 负荷最重的top10的作业列表以及其成功率
	 */
	SaturnStatistics top10LoadJob(String key) throws SaturnJobConsoleException;

	String top10LoadJobByAllZkCluster() throws SaturnJobConsoleException;

	/**
	 * 稳定性最差的top10的域列表
	 */
	SaturnStatistics top10UnstableDomain(String key) throws SaturnJobConsoleException;

	String top10UnstableDomainByAllZkCluster() throws SaturnJobConsoleException;

	/**
	 * 全域当天处理总数，失败总数
	 */
	SaturnStatistics allProcessAndErrorCountOfTheDay(String key) throws SaturnJobConsoleException;

	String allProcessAndErrorCountOfTheDayByAllZkCluster() throws SaturnJobConsoleException;

	SaturnStatistics top10FailureExecutor(String key) throws SaturnJobConsoleException;

	String top10FailureExecutorByAllZkCluster() throws SaturnJobConsoleException;

	/**
	 * 清除该域下的/$SaturnExecutors/sharding/count
	 */
	void cleanShardingCount(String namespace) throws SaturnJobConsoleException;

	void cleanOneJobAnalyse(String namespace, String jobName) throws SaturnJobConsoleException;

	void cleanAllJobAnalyse(String namespace) throws SaturnJobConsoleException;

	void cleanAllJobExecutorCount(String namespace) throws SaturnJobConsoleException;

	void cleanOneJobExecutorCount(String namespace, String jobName) throws SaturnJobConsoleException;

	Map<String, Integer> loadDomainRankDistribution(String key) throws SaturnJobConsoleException;

	Map<String, Integer> loadDomainRankDistributionByAllZkCluster() throws SaturnJobConsoleException;

	Map<Integer, Integer> loadJobRankDistribution(String key) throws SaturnJobConsoleException;

	Map<Integer, Integer> loadJobRankDistributionByAllZkCluster() throws SaturnJobConsoleException;

	Map<String, Long> versionDomainNumber(String key) throws SaturnJobConsoleException;

	Map<String, Long> versionDomainNumberByAllZkCluster() throws SaturnJobConsoleException;

	Map<String, Long> versionExecutorNumber(String key) throws SaturnJobConsoleException;

	Map<String, Long> versionExecutorNumberByAllZkCluster() throws SaturnJobConsoleException;

	/**
	 * 保存dashboard历史
	 * @param zkCluster
	 * @param type
	 * @param topic
	 * @param content
	 */
	void saveDashboardHistory(String zkCluster, String type, String topic, String content);

	/**
	 * 批量保存dashboard历史
	 * @param dashboardHistories
	 */
	void batchSaveDashboardHistory(List<DashboardHistory> dashboardHistories);

	/**
	 * 获取domain历史
	 */
	List<DashboardHistory> getDashboardDomainHistory(String zkCluster, String type, String topic, Date fromDate,
			Date toDate) throws SaturnJobConsoleException;


	/**
	 * 获取全域执行历史数据
	 * @param type
	 * @param topic
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	Map<String, List> getDomainOperationHistory(String type, String topic, Date fromDate, Date toDate);

	/**
	 * 获取某个集群域历史个数
	 * @param zkCluster
	 * @param type
	 * @param topic
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	Map<String, List> getDomainCountHistory(String zkCluster, String type, String topic, Date fromDate,
			Date toDate);

	/**
	 * 获取Executor历史个数
	 * @param zkCluster
	 * @param type
	 * @param topic
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	Map<String, List> getExecutorHistory(String zkCluster, String type, String topic, Date fromDate,
			Date toDate);

	/**
	 * 获取作业历史个数
	 * @param zkCluster
	 * @param type
	 * @param topic
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	Map<String, List> getJobCountHistory(String zkCluster, String type, String topic, Date fromDate,
			Date toDate);

}
