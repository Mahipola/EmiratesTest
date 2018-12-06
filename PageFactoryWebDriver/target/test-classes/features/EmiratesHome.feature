Feature: Book Flight tickets online

Scenario: Bill wants to travel from DXB to LHR
Given Bill has decided to check available flights
When Bill looks at a return trip from "DXB" to "LHR" leaving one week from now
Then Bill should be shown the cheapest return ticket from "DXB" to "LHR"