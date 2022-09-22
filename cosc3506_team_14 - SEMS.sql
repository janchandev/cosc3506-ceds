-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 15, 2022 at 10:23 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12
CREATE DATABASE cemsdb;
USE cemsdb;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cosc3506 team 14`
--

-- --------------------------------------------------------

--
-- Table structure for table `createevent`
--

CREATE TABLE `createevent` (
  `CreateEventID` int(4) NOT NULL,
  `EventName` varchar(50) NOT NULL,
  `Club` varchar(50) NOT NULL,
  `Description` varchar(200) NOT NULL,
  `Date` date NOT NULL,
  `Time` time(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `editclubdetails`
--

CREATE TABLE `editclubdetails` (
  `EditClubID` int(4) NOT NULL,
  `ClubName` varchar(50) NOT NULL,
  `ContactEmail` varchar(50) NOT NULL,
  `MembershipPrice` int(4) NOT NULL,
  `ClubDescription` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `editeventdetails`
--

CREATE TABLE `editeventdetails` (
  `EventID` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `joinevents`
--

CREATE TABLE `joinevents` (
  `JoinEventsID` int(4) NOT NULL,
  `EventName` varchar(50) NOT NULL,
  `ClubName` varchar(50) NOT NULL,
  `Description` varchar(200) NOT NULL,
  `DateTime` datetime(6) NOT NULL,
  `Actions` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `LoginRegID` int(4) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `StudentID` int(10) NOT NULL,
  `ContactEmail` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `manageclubmembers`
--

CREATE TABLE `manageclubmembers` (
  `ManageClubMembersID` int(4) NOT NULL,
  `Club Name` varchar(50) NOT NULL,
  `StudentID` int(25) NOT NULL,
  `MemberName` varchar(50) NOT NULL,
  `ContactEmail` varchar(50) NOT NULL,
  `RemoveMember` varchar(5) NOT NULL DEFAULT 'No'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `manageclubs`
--

CREATE TABLE `manageclubs` (
  `ManageClubID` int(4) NOT NULL,
  `ClubName` varchar(50) NOT NULL,
  `ClubDescription` varchar(200) NOT NULL,
  `ContactEmail` varchar(50) NOT NULL,
  `MembershipPrice` int(4) NOT NULL,
  `NoMembers` int(5) NOT NULL,
  `TotalFunds` int(5) NOT NULL,
  `Actions` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `manageevent`
--

CREATE TABLE `manageevent` (
  `ManageEventsID` int(4) NOT NULL,
  `EventName` varchar(50) NOT NULL,
  `ClubName` varchar(50) NOT NULL,
  `Description` varchar(500) NOT NULL,
  `DateTime` datetime(6) NOT NULL,
  `NoAttendees` int(5) NOT NULL,
  `Actions` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `manageeventattendees`
--

CREATE TABLE `manageeventattendees` (
  `ManageEventAttendeesID` int(4) NOT NULL,
  `EventName` varchar(50) NOT NULL,
  `StudentID` int(6) NOT NULL,
  `MemberName` varchar(25) NOT NULL,
  `ContactEmail` varchar(50) NOT NULL,
  `RemoveAttendee` varchar(5) NOT NULL DEFAULT 'No'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `managenotifications`
--

CREATE TABLE `managenotifications` (
  `ManageNotificationsID` int(4) NOT NULL,
  `ClubName` varchar(50) NOT NULL,
  `Notfication` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `viewclubs`
--

CREATE TABLE `viewclubs` (
  `ViewClubID` int(4) NOT NULL,
  `ClubName` varchar(50) NOT NULL,
  `ClubDescription` varchar(200) NOT NULL,
  `ContactEmail` varchar(50) NOT NULL,
  `LeaveClub` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `createevent`
--
ALTER TABLE `createevent`
  ADD PRIMARY KEY (`CreateEventID`);

--
-- Indexes for table `editeventdetails`
--
ALTER TABLE `editeventdetails`
  ADD PRIMARY KEY (`EventID`) USING BTREE;

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`LoginRegID`);

--
-- Indexes for table `manageclubmembers`
--
ALTER TABLE `manageclubmembers`
  ADD PRIMARY KEY (`ManageClubMembersID`);

--
-- Indexes for table `manageclubs`
--
ALTER TABLE `manageclubs`
  ADD PRIMARY KEY (`ManageClubID`);

--
-- Indexes for table `manageevent`
--
ALTER TABLE `manageevent`
  ADD PRIMARY KEY (`ManageEventsID`);

--
-- Indexes for table `manageeventattendees`
--
ALTER TABLE `manageeventattendees`
  ADD PRIMARY KEY (`ManageEventAttendeesID`);

--
-- Indexes for table `managenotifications`
--
ALTER TABLE `managenotifications`
  ADD PRIMARY KEY (`ManageNotificationsID`);

--
-- Indexes for table `viewclubs`
--
ALTER TABLE `viewclubs`
  ADD PRIMARY KEY (`ViewClubID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `createevent`
--
ALTER TABLE `createevent`
  MODIFY `CreateEventID` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `editeventdetails`
--
ALTER TABLE `editeventdetails`
  MODIFY `EventID` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `LoginRegID` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `manageclubmembers`
--
ALTER TABLE `manageclubmembers`
  MODIFY `ManageClubMembersID` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `manageclubs`
--
ALTER TABLE `manageclubs`
  MODIFY `ManageClubID` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `manageevent`
--
ALTER TABLE `manageevent`
  MODIFY `ManageEventsID` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `manageeventattendees`
--
ALTER TABLE `manageeventattendees`
  MODIFY `ManageEventAttendeesID` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `managenotifications`
--
ALTER TABLE `managenotifications`
  MODIFY `ManageNotificationsID` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `viewclubs`
--
ALTER TABLE `viewclubs`
  MODIFY `ViewClubID` int(4) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


CREATE TABLE `registration` (
  `id` bigint(20) NOT NULL,
  `full_name` varchar(250) NOT NULL,
  `email_id` varchar(250) NOT NULL,
  `password` varchar(250) DEFAULT NULL,
  `student_id` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `registration`
  ADD PRIMARY KEY (`id`);

--
ALTER TABLE `registration`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
  
UPDATE manageclubs SET  TotalFunds = MembershipPrice * NoMembers;
ALTER TABLE manageevent DROP COLUMN Actions;
ALTER TABLE manageclubs DROP COLUMN Actions;
ALTER TABLE manageeventattendees DROP COLUMN RemoveAttendee;
ALTER TABLE manageclubmembers DROP COLUMN RemoveMember;
ALTER TABLE viewclubs DROP COLUMN LeaveClub;
ALTER TABLE joinevents DROP COLUMN Actions;
