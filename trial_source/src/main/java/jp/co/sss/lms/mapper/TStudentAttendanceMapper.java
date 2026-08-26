package jp.co.sss.lms.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import jp.co.sss.lms.dto.AttendanceManagementDto;
import jp.co.sss.lms.entity.TStudentAttendance;

/**
 * 勤怠情報（受講生入力）テーブルマッパー
 * 
 * @author 東京ITスクール
 */
@Mapper
public interface TStudentAttendanceMapper {

	/**
	 * 勤怠情報（受講生入力）取得（LMSユーザーID） 東京ITスクール
	 */
	List<TStudentAttendance> findByLmsUserId(@Param("lmsUserId") Integer lmsUserId,
			@Param("deleteFlg") Short deleteFlg);

	/**
	 * 勤怠情報（受講生入力）取得（LMSユーザーID＆日付）　東京ITスクール
	 */
	TStudentAttendance findByLmsUserIdAndTrainingDate(@Param("lmsUserId") Integer lmsUserId,
			@Param("trainingDate") Date trainingDate, @Param("deleteFlg") Short deleteFlg);

	/**
	 * 勤怠管理画面用DTOリスト取得　東京スクール
	 */
	List<AttendanceManagementDto> getAttendanceManagement(@Param("courseId") Integer courseId,
			@Param("lmsUserId") Integer lmsUserId, @Param("deleteFlg") Short deleteFlg);

	/**
	 * 過去日の勤怠未入力件数取得
	 *@author h-ochiai
	 * @param lmsUserId
	 * @param deleteFlg
	 * @param trainingDate
	 * @return 過去日の勤怠未入力件数
	 */
	Integer notEnterCount(
			@Param("lmsUserId") Integer lmsUserId,
			@Param("deleteFlg") Short deleteFlg,
			@Param("trainingDate") Date trainingDate);

	/**
	* 勤怠情報（受講生入力）登録　　東京ITスクール
	*/
	Boolean insert(TStudentAttendance tStudentAttendance);

	/**
	 * 勤怠情報（受講生入力）更新　　東京ITスクール
	 */
	Boolean update(TStudentAttendance tStudentAttendance);

}
