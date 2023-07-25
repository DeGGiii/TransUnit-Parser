# TransUnit Parser
The goal of this project is to parse the given XML file and write the target value of trans-unit with id 42007 to another file.
## Problem

Get the value in the element **_target_** when the attribute **_id_** is 42007 and write it to another file.
```XML
<?xml version="1.0" encoding="UTF-8"?>
<root version="1.2">
	<file source-language="en" target-language="sv-se" >
		<body>
			<group resname="_ptcsma.acl" restype="file"/>
			<trans-unit id="42006" restype="string">
				<source>WARNING</source>
				<target>VARNING</target>
			</trans-unit>
			<trans-unit id="42007" restype="string">
				<source>Note</source>
				<target>Obs!</target>
			</trans-unit>
			<trans-unit id="42008" restype="string">
				<source>DANGER</source>
				<target>FARA</target>
			</trans-unit>
			<trans-unit id="42009" restype="string">
				<source>CAUTION</source>
				<target>FÖRSIKTIGHET</target>
			</trans-unit>
		</body>
	</file>
</root>
```
## Problem analysis
This being my first time working with XML, I was quite happy with how well it went for me. Although this being a smaller assignment,
it was very fun working with and to challenge myself on working outside the comfort zone with another programming language.

As for the assignment given to me, I supposed that all IDs are unique because usually there is an XML schema to work from. That's
why I did not deal with this. 

The library used for this project is dom4j. I felt that I found all the necessary functions I needed for this project in the dom4j package.