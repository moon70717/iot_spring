-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.2.11-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 테이블 데이터 dbconnector.connection_info:~4 rows (대략적) 내보내기
/*!40000 ALTER TABLE `connection_info` DISABLE KEYS */;
INSERT INTO `connection_info` (`ciNo`, `ciName`, `ciUrl`, `ciPort`, `ciDatabase`, `ciUser`, `ciPwd`, `uId`, `ciEtc`) VALUES
	(1, 'local', '192.168.0.12', 3306, 'dbconnector', 'dbtest', 'dbtest', 'red', NULL),
	(2, 'local', '192.168.0.12', 3306, 'iot2', 'root', 'root', 'root', NULL),
	(7, '123', '123', 123, '123', '123', '123', '3', ''),
	(11, '124', '12414', 1424, '12412', '124124', '124124', '4', '');
/*!40000 ALTER TABLE `connection_info` ENABLE KEYS */;

-- 테이블 데이터 dbconnector.user_info:~9 rows (대략적) 내보내기
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` (`uNo`, `uName`, `uId`, `uPwd`, `uEmail`, `admin`) VALUES
	(1, 'hong', 'red', 'red', 'red@red.com', '0'),
	(2, 'hongr', 'root', 'root', 'red@red.com', '1'),
	(3, 'asd', '2', '2', '2', '0'),
	(4, 'asd', '3', '3', '3', '0'),
	(5, 'asd', '4', '4', '4', '0'),
	(6, 'asfa', 'asfasf', 'asf', 'asf', '1'),
	(7, 'blue', 'blue', 'blue', 'blue', '1'),
	(10, '414124', '1244', '124412', '12412', '1'),
	(11, '41241424', '12412', '4142414', '14124', '1');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
