-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8111
-- Generation Time: May 14, 2021 at 07:52 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fundcl`
--

-- --------------------------------------------------------

--
-- Table structure for table `fundcl`
--

CREATE TABLE `fundcl` (
  `FID` int(4) NOT NULL,
  `FunderCode` varchar(4) NOT NULL,
  `CompanyName` varchar(100) NOT NULL,
  `ContactNo` int(10) NOT NULL,
  `CompanyDesc` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fundcl`
--

INSERT INTO `fundcl` (`FID`, `FunderCode`, `CompanyName`, `ContactNo`, `CompanyDesc`) VALUES
(1, '0001', 'eee', 877665511, 'sdft'),
(2, '0001', 'eee', 877665511, 'sdft');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `fundcl`
--
ALTER TABLE `fundcl`
  ADD PRIMARY KEY (`FID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `fundcl`
--
ALTER TABLE `fundcl`
  MODIFY `FID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
