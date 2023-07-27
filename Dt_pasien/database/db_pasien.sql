SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE IF NOT EXISTS `db_pasien` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `db_pasien`;

CREATE TABLE `admin` (
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `admin` (`Username`, `Password`) VALUES
('admin1', '123');

CREATE TABLE `dokter` (
  `kd_dokter` int(11) NOT NULL,
  `nm_dokter` varchar(50) NOT NULL,
  `jns_kelamin` char(10) NOT NULL,
  `spesialis` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `dokter` (`kd_dokter`, `nm_dokter`, `jns_kelamin`, `spesialis`) VALUES
(1, 'Alvin', 'Laki Laki', 'THT (Telinga Hidung Tenggorokan)'),
(2, 'Devin Aksa', 'Laki Laki', 'Jantung');

CREATE TABLE `pasien` (
  `kd_pasien` int(11) NOT NULL,
  `nm_pasien` varchar(50) NOT NULL,
  `jns_kelamin` char(10) NOT NULL,
  `jns_periksa` varchar(50) NOT NULL,
  `kd_dokter` int(11) NOT NULL,
  `biaya` int(11) NOT NULL,
  `obat` varchar(50) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


ALTER TABLE `dokter`
  ADD PRIMARY KEY (`kd_dokter`);

ALTER TABLE `pasien`
  ADD PRIMARY KEY (`kd_pasien`),
  ADD KEY `FK_DokterPasien` (`kd_dokter`);


ALTER TABLE `pasien`
  ADD CONSTRAINT `FK_DokterPasien` FOREIGN KEY (`kd_dokter`) REFERENCES `dokter` (`kd_dokter`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
