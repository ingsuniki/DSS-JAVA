-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 27, 2019 at 12:18 PM
-- Server version: 10.3.15-MariaDB
-- PHP Version: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `xgdss`
--

-- --------------------------------------------------------

--
-- Table structure for table `fkaryawan`
--

CREATE TABLE `fkaryawan` (
  `idkaryawan` varchar(30) NOT NULL,
  `namakaryawan` varchar(60) NOT NULL,
  `jabatan` varchar(40) NOT NULL,
  `Alamat` varchar(255) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `Telp` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fkaryawan`
--

INSERT INTO `fkaryawan` (`idkaryawan`, `namakaryawan`, `jabatan`, `Alamat`, `Email`, `Telp`) VALUES
('DSS00XG0311', 'Denny Setiawan', 'Sales Counter', 'Jl. Hj. Aom No.19 Kebayoran Baru Jakarta Selatan', 'denny.s@xg.co.id', '089665899928'),
('DSS00XG0312', 'Eko Setiawan', 'Computer Graphics Operator', 'Jl.Magetan Raya Pekalongan Selatan', 'eco.ubi@xg.co.id', '081190901234'),
('DSS00XG0313', 'Kusnoyo', 'B2B', 'Jl. Hj. Aom No.19 Kebayoran Baru Jakarta Selatan', 'denny.s@xg.co.id', '089665899928'),
('DSS00XG0314', 'Leny Setianingsih', 'Sales Counter', 'Jl. Hj. Aom No.19 Kebayoran Baru Jakarta Selatan', 'denny.s@xg.co.id', '089665899928'),
('DSS00XG0315', 'Regina Novianti', 'Supervisor', 'Jl. Hj. Aom No.19 Kebayoran Baru Jakarta Selatan', 'denny.s@xg.co.id', '089665899928'),
('DSS00XG0316', 'Hartono', 'Marketing', 'Jl. Hj. Aom No.19 Kebayoran Baru Jakarta Selatan', 'denny.s@xg.co.id', '089665899928'),
('DSS00XG0317', 'Mufid Pangestu', 'Computer Graphics Operator', 'Jl. Hj. Aom No.19 Kebayoran Baru Jakarta Selatan', 'denny.s@xg.co.id', '089665899928'),
('DSS00XG0318', 'Doni Kurniadi', 'Telemarketing', 'Jl. Hj. Aom No.19 Kebayoran Baru Jakarta Selatan', 'denny.s@xg.co.id', '089665899928'),
('DSS00XG0319', 'Apri Rama', 'Sales Counter', 'Jl. Hj. Aom No.19 Kebayoran Baru Jakarta Selatan', 'denny.s@xg.co.id', '089665899928'),
('DSS00XG0320', 'Aisyah Lubis', 'Computer Graphics Operator', 'Jl. Hj. Aom No.19 Kebayoran Baru Jakarta Selatan', 'denny.s@xg.co.id', '089665899928'),
('DSS00XG0321', 'Beni Satrio', 'B2B', 'Jl. Hj. Aom No.19 Kebayoran Baru Jakarta Selatan', 'denny.s@xg.co.id', '089665899928'),
('DSS00XG0322', 'Syubanul Umam', 'B2B', 'Jl. Hj. Aom No.19 Kebayoran Baru Jakarta Selatan', 'denny.s@xg.co.id', '089665899928'),
('DSS00XG0323', 'Muhammad Mutakin', 'Supervisor', 'Jl. Hj. Aom No.19 Kebayoran Baru Jakarta Selatan', 'denny.s@xg.co.id', '089665899928'),
('DSS00XG0324', 'Sarno Sihwanto', 'Sales Counter', 'Jl. Hj. Aom No.19 Kebayoran Baru Jakarta Selatan', 'denny.s@xg.co.id', '089665899928'),
('DSS00XG0325', 'Rian Rachmatullah', 'Computer Graphics Operator', 'Jl. Hj. Aom No.19 Kebayoran Baru Jakarta Selatan', 'denny.s@xg.co.id', '089665899928'),
('DSS00XG0326', 'Daky Zulkarnain', 'Marketing', 'Jl. Hj. Aom No.19 Kebayoran Baru Jakarta Selatan', 'denny.s@xg.co.id', '089665899928'),
('DSS00XG0327', 'Derry Syaputra', 'B2B', 'Jl. Hj. Aom No.19 Kebayoran Baru Jakarta Selatan', 'denny.s@xg.co.id', '089665899928'),
('DSS00XG0328', 'Bimo Dwi Putranto', 'Marketing', 'Jl. Hj. Aom No.19 Kebayoran Baru Jakarta Selatan', 'denny.s@xg.co.id', '089665899928'),
('DSS00XG0329', 'Robby Rodian', 'B2B', 'Jl. Hj. Aom No.19 Kebayoran Baru Jakarta Selatan', 'denny.s@xg.co.id', '089665899928'),
('DSS00XG0330', 'Yogi Dwi Trisnawan', 'Sales Counter', 'Jl. Hj. Aom No.19 Kebayoran Baru Jakarta Selatan', 'denny.s@xg.co.id', '089665899928');

-- --------------------------------------------------------

--
-- Table structure for table `ftarget`
--

CREATE TABLE `ftarget` (
  `idjabatan` varchar(255) NOT NULL,
  `jabatan` varchar(255) NOT NULL,
  `kkg1` int(200) NOT NULL,
  `kkg2` int(200) NOT NULL,
  `kkg3` int(200) NOT NULL,
  `hkg1` int(200) NOT NULL,
  `hkg2` int(200) NOT NULL,
  `hkg3` int(200) NOT NULL,
  `tq1` int(200) NOT NULL,
  `tq2` int(200) NOT NULL,
  `tq3` int(200) NOT NULL,
  `tq4` int(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ftarget`
--

INSERT INTO `ftarget` (`idjabatan`, `jabatan`, `kkg1`, `kkg2`, `kkg3`, `hkg1`, `hkg2`, `hkg3`, `tq1`, `tq2`, `tq3`, `tq4`) VALUES
('B2B001XG', 'B2B', 100, 80, 60, 23, 14, 8, 300000000, 630000000, 200000000, 200000000),
('CG001XG', 'Computer Graphics Operator', 100, 80, 60, 20, 12, 5, 250000000, 300000000, 275000000, 325000000),
('MK001XG', 'Marketing', 100, 80, 60, 20, 12, 5, 500000000, 420000000, 370000000, 650000000),
('SC001XG', 'Sales Counter', 100, 80, 60, 20, 12, 5, 300000000, 220000000, 340000000, 340000000),
('SM001XG', 'Store Manager', 100, 80, 60, 20, 12, 5, 80000000, 700000000, 800000000, 900000000),
('SPV001XG', 'Supervisor', 100, 80, 60, 23, 14, 8, 400000000, 400000000, 500000000, 600000000),
('TM001XG', 'Telemarketing', 100, 80, 60, 25, 10, 8, 200000000, 200000000, 200000000, 200000000);

-- --------------------------------------------------------

--
-- Table structure for table `fuser`
--

CREATE TABLE `fuser` (
  `idPengguna` int(60) NOT NULL,
  `username` varchar(60) NOT NULL,
  `password` varchar(40) NOT NULL,
  `authority` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fuser`
--

INSERT INTO `fuser` (`idPengguna`, `username`, `password`, `authority`) VALUES
(1, 'admin1', '122', 'Admin'),
(2, 'admin3', '122', 'Admin'),
(3, 'manager', '000', 'Manager'),
(4, 'manager2', '000', 'Manager'),
(5, 'admin2', '122', 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `fkaryawan`
--
ALTER TABLE `fkaryawan`
  ADD PRIMARY KEY (`idkaryawan`);

--
-- Indexes for table `ftarget`
--
ALTER TABLE `ftarget`
  ADD PRIMARY KEY (`idjabatan`);

--
-- Indexes for table `fuser`
--
ALTER TABLE `fuser`
  ADD PRIMARY KEY (`idPengguna`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `fuser`
--
ALTER TABLE `fuser`
  MODIFY `idPengguna` int(60) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
