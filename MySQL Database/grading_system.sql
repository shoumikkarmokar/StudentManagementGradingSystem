-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 11, 2019 at 04:34 AM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `grading_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `Cid` int(11) UNSIGNED NOT NULL,
  `Name` varchar(15) NOT NULL,
  `CreditHrs` smallint(6) NOT NULL,
  `Pid` int(11) UNSIGNED DEFAULT NULL,
  `Did` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`Cid`, `Name`, `CreditHrs`, `Pid`, `Did`) VALUES
(26, 'CSE 115', 3, 71, 55),
(27, 'CSE 227', 3, 71, 55),
(28, 'CSE 255', 3, 71, 55),
(29, 'ENV 342', 4, 71, 63),
(30, 'ENV 125', 3, 71, 63),
(31, 'MCT 253', 3, 71, 62),
(32, 'MCT 123', 3, 71, 62),
(33, 'LND 111', 3, 71, 61),
(34, 'LND 425', 3, 71, 61),
(36, 'LND 326', 3, 71, 61),
(37, 'LND 215', 4, 71, 61),
(38, 'ENR 465', 3, 71, 60),
(39, 'ENR 371', 3, 71, 60),
(40, 'ENR 216', 3, 71, 60),
(41, 'MAN 430', 3, 71, 59),
(42, 'MAN 269', 3, 71, 59),
(43, 'MTL 126', 3, 71, 58),
(44, 'BLD 115', 3, 71, 57),
(45, 'BLD 251', 3, 71, 57),
(46, 'COM 254', 3, 71, 56),
(47, 'COM 322', 3, 71, 56),
(48, 'CSE 324', 3, 71, 55),
(49, 'CSE 126', 3, 71, 55);

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `Did` int(11) UNSIGNED NOT NULL,
  `Name` text NOT NULL,
  `Description` text NOT NULL,
  `Email` text NOT NULL,
  `Mid` int(11) UNSIGNED DEFAULT NULL,
  `Uid` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`Did`, `Name`, `Description`, `Email`, `Mid`, `Uid`) VALUES
(54, 'Administration', 'Welcome to Ain Shams University Administration.', 'Admin@eng.asu.edu.eg', 71, 23),
(55, 'Computer Engineering', 'Computer and Software Systems Engineers are concerned with software engineering with a strong emphasis on computer engineering. The program opens a whole world of career opportunities to its graduates in software product lines, mobile and pervasive computing, cloud computing, embedded systems, multimedia, 3D graphics, game design, etc.\n\n Graduates of this program can be specialized in:\n\nSoftware development life cycles\nAnalysis, modeling, design, and quality assurance of software systems\nEmbedded systems\nComputer graphics and multimedia\nCloud computing and big-data analytics\nMobile computing\nComputer networking and security', 'computer_program@eng.asu.edu.eg', 71, 23),
(56, 'Communication Systems Engineering', 'Communication Systems Engineers deal with the wide areas of communication and telecommunication networks, multimedia systems (video and voice), wireless communication, cellular and satellite networks, microwave communication systems, and optical communication systems. Communication Systems Engineers are specialized in:\n\nTelecommunications\nData communications\nOptical communications\nSignal processing\nPhotonics\nMicrowave systems', 'commpunication_program@eng.asu.edu.eg', 71, 23),
(57, 'Building Department', 'Meeting the needs of the Egyptian construction industry.\n\nPreparing engineers with the overall design of built facilities.\n\nEngineers will have the ability to design building with performance in mind (energy efficiency, passive solar engineering, lighting and acoustics, indoor air quality, construction management, HVAC, …etc.).', 'building_program@eng.asu.edu.eg', 71, 23),
(58, 'Materials Engineering', 'Materials Engineers are concerned with the relationship between atomic structure of material and its performance with respect to design and processing conditions. Optimum material selection within the fields of mechanical, civil, electronic, and medical engineering targets the facilitation of daily activities. Materials Engineers deal mainly with:\n\nMetals and alloys\nPolymers and composites\nGlasses and ceramics\nCementitous materials\nElectronic materials\nNano materials', 'materials_program@eng.asu.edu.eg', 71, 23),
(59, 'Manufacture Engineering', 'Manufacturing Engineers design, construct, and improve engineering products; they convert raw materials into useful products with the required specifications and minimum cost.  Manufacturing Engineers are specialized in:\n\nMetal cutting and material forming\nMechanical measurement\nRobotics and computer numerical controlled machines\nProduct design\nMaterial fabrication\nIndustrial organization of manufacturing supply chain', 'manufacture_program@eng.asu.edu.eg', 71, 23),
(60, 'Energy and Renewable Energy Engineering', 'Energy and Renewable Energy Engineers deal with the different renewable energy resources such as wind, photovoltaic, solar, hydro, fuel cells, and new technologies. It is a multi-disciplinary program that covers different topics to make future engineers understand the renewable energy resources; how they work and how to use them in applications. Energy and Renewable Energy Engineers are specialized in:\n\nWind energy power plants\nSolar and photovoltaic energy\nEnergy conversion\nInterfacing technology\nWater desalination', 'energy_program@eng.asu.edu.eg', 71, 23),
(61, 'Landscape Engineering', 'Landscape Architects are specialized in landscape design. Landscape architecture program provides the students with the specialization courses of landscape in an integrated framework with scientific courses of architecture, urban design and planning, in addition to basic scientific and engineering courses. Graduates of this program can be specialized in:\n\nThe harmony between building design and open and green spaces\nThe aesthetical and functional dimensions for landscape elements\nDealing with different environments and levels as urban areas, coastal facades, and desert and mountainous sites\nCreating designs that fulfill human needs, preserve the environment, save energy, and realize sustainability', 'landscape_program@eng.asu.edu.eg', 71, 23),
(62, 'Mechatronics Engineering', 'Mechatronics and Automation Engineers are concerned with Mechatronics Engineering with a strong emphasis on one of the fields: Industrial Automation, Autotronics, Bio-Mechatronics, or Nano-Mechatronics. Graduates of this program can be specialized in:\n\nMechatronics systems\nIndustrial automation systems\nMicro/Nano Electro-Mechanical Systems\nAutomotive systems\nBio-medical systems\nEmbedded systems, robotics ... etc.', 'mechatronics_program@eng.asu.edu.eg', 71, 23),
(63, 'Environmental Architecture Engineering', 'The main goal of the program is to prepare architects and urban planners specialized in environmental design. Graduates are capable of understanding the relationship between humans and buildings and between buildings and their environment. They are capable of integrating all the aspects dealing with the built environment and how it is planned, designed, used, furnished, landscaped, managed, and valued by the society in their creative thinking while dealing with complex architectural and urban environment problems. The program introduces students to building science and enables them to conceive the basic concepts of sustainable architecture and urbanism. They are trained to balance functional and ecological demands when developing policies or designs for new construction. Graduate will be able to deal with modern techniques and tools for learning and linking theory and practice. All efforts are directed towards achieving environmental architecture and urbanism. The study in this program is expected to start after fullfilling the required steps to eztablish this program.', 'environmental_program@eng.asu.edu.eg', 71, 23);

-- --------------------------------------------------------

--
-- Table structure for table `department_telephone`
--

CREATE TABLE `department_telephone` (
  `Did` int(11) UNSIGNED NOT NULL,
  `Telephone` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `instructor`
--

CREATE TABLE `instructor` (
  `Pid` int(11) UNSIGNED NOT NULL,
  `Salary` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `instructor`
--

INSERT INTO `instructor` (`Pid`, `Salary`) VALUES
(71, 45000);

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `Pid` int(11) UNSIGNED NOT NULL,
  `Fname` varchar(15) NOT NULL,
  `Mname` varchar(15) NOT NULL,
  `Lname` varchar(15) NOT NULL,
  `Email` text NOT NULL,
  `Gender` varchar(6) NOT NULL,
  `Telephone` varchar(11) NOT NULL,
  `Did` int(11) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`Pid`, `Fname`, `Mname`, `Lname`, `Email`, `Gender`, `Telephone`, `Did`) VALUES
(71, 'Mahmoud', 'Mohamed', 'Khalil', 'Admin@eng.asu.edu.eg', 'Male', '01002265485', 54),
(73, 'Abdelrahman', 'Ibrahim', 'ELGhamry', 'ghamry98@hotmail.com', 'Male', '01060661580', 55),
(74, 'Hossam', 'ElDin', 'Khaled', 'hossampen97@gmail.com', 'Male', '01000223621', 56),
(75, 'Youssef', 'Hossam', 'ElKenawy', 'youssefhossam@hotmail.com', 'Male', '01115469875', 62),
(76, 'Ahmed', 'Ali', 'Hassan', 'ahmedhassan@outlook.co.uk', 'Male', '01533361521', 57);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `Pid` int(11) UNSIGNED NOT NULL,
  `GPA` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`Pid`, `GPA`) VALUES
(73, 3.93),
(74, 3.9),
(75, 3.7),
(76, 2.95);

-- --------------------------------------------------------

--
-- Table structure for table `student_takes_course`
--

CREATE TABLE `student_takes_course` (
  `Pid` int(11) UNSIGNED NOT NULL,
  `Cid` int(11) UNSIGNED NOT NULL,
  `Grade` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_takes_course`
--

INSERT INTO `student_takes_course` (`Pid`, `Cid`, `Grade`) VALUES
(73, 26, 4),
(73, 27, 4),
(73, 28, 3.9),
(73, 48, 3.8),
(74, 46, 3.8),
(74, 47, 4),
(75, 31, 3.6),
(75, 32, 3.8),
(76, 44, 2.7),
(76, 45, 3.2);

-- --------------------------------------------------------

--
-- Table structure for table `university`
--

CREATE TABLE `university` (
  `Uid` int(11) UNSIGNED NOT NULL,
  `Name` text NOT NULL,
  `Address` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `university`
--

INSERT INTO `university` (`Uid`, `Name`, `Address`) VALUES
(23, 'Ain Shams University', '1 Al-Sarayyat St, Abbassiya, Cairo 11517, Egypt');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`Cid`),
  ADD KEY `Pid` (`Pid`),
  ADD KEY `Did` (`Did`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`Did`),
  ADD KEY `Mid` (`Mid`),
  ADD KEY `Uid` (`Uid`);

--
-- Indexes for table `department_telephone`
--
ALTER TABLE `department_telephone`
  ADD PRIMARY KEY (`Did`,`Telephone`) USING BTREE,
  ADD KEY `Did` (`Did`);

--
-- Indexes for table `instructor`
--
ALTER TABLE `instructor`
  ADD PRIMARY KEY (`Pid`),
  ADD KEY `Pid` (`Pid`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`Pid`),
  ADD KEY `Did` (`Did`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`Pid`),
  ADD KEY `Pid` (`Pid`);

--
-- Indexes for table `student_takes_course`
--
ALTER TABLE `student_takes_course`
  ADD PRIMARY KEY (`Pid`,`Cid`) USING BTREE,
  ADD KEY `Pid` (`Pid`),
  ADD KEY `Cid` (`Cid`);

--
-- Indexes for table `university`
--
ALTER TABLE `university`
  ADD PRIMARY KEY (`Uid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `Cid` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `Did` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `Pid` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=77;

--
-- AUTO_INCREMENT for table `university`
--
ALTER TABLE `university`
  MODIFY `Uid` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `course_ibfk_1` FOREIGN KEY (`Pid`) REFERENCES `instructor` (`Pid`) ON DELETE SET NULL ON UPDATE SET NULL,
  ADD CONSTRAINT `course_ibfk_2` FOREIGN KEY (`Did`) REFERENCES `department` (`Did`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `department`
--
ALTER TABLE `department`
  ADD CONSTRAINT `department_ibfk_1` FOREIGN KEY (`Uid`) REFERENCES `university` (`Uid`),
  ADD CONSTRAINT `department_ibfk_2` FOREIGN KEY (`Mid`) REFERENCES `instructor` (`Pid`) ON DELETE SET NULL ON UPDATE SET NULL;

--
-- Constraints for table `department_telephone`
--
ALTER TABLE `department_telephone`
  ADD CONSTRAINT `department_telephone_ibfk_1` FOREIGN KEY (`Did`) REFERENCES `department` (`Did`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `instructor`
--
ALTER TABLE `instructor`
  ADD CONSTRAINT `instructor_ibfk_1` FOREIGN KEY (`Pid`) REFERENCES `person` (`Pid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `person`
--
ALTER TABLE `person`
  ADD CONSTRAINT `person_ibfk_1` FOREIGN KEY (`Did`) REFERENCES `department` (`Did`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`Pid`) REFERENCES `person` (`Pid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `student_takes_course`
--
ALTER TABLE `student_takes_course`
  ADD CONSTRAINT `student_takes_course_ibfk_1` FOREIGN KEY (`Pid`) REFERENCES `student` (`Pid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `student_takes_course_ibfk_2` FOREIGN KEY (`Cid`) REFERENCES `course` (`Cid`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
