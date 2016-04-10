**Attendees:** Sven (ONTRAM), Gergely (Kilgray), Micah (Medtronic), Chase (Spartan)

## Action Items ##
  * Set up a separate mailing list for implementors (Sven)

## Agenda ##
  * Identify implementors
  * Get status of each implementation
  * Look for ways to coordinate
  * Assess completeness of specifications
  * Identify possible roadblocks
  * Discuss how to enable real testing between systems (when we're ready)
  * Discuss (proposed) LocWorld presentation

### Implementors ###
  * Kilgray: Gergely will be doing most of the design, assisted by Gabor.  Implementation will be done by an external resource.
  * Medtronic: Micah is implementing for the QA checker.
  * Ontram: Timo is in charge
  * GlobalSight: unknown
  * XTM: unknown
  * Reference implementation: Chase

### Status of existing implementations ###
  * Kilgray
    * Nothing written yet; goal to support 80% of xliff:doc by LocWorld.
    * Written in .NET
  * Ontram
    * No proper development since TM-Europe demo
    * Had basic implementation of TIPP and xliff:doc, but unfinished.
    * Implemented for TM-Europe: basic TIPP, TM matches, notes, no terminology
    * Some areas may need updating to handle changes to the specs
  * GS
    * For TM-Europe demo, used reference implementation for TIPP, hacked together very bad xliff:doc support.
    * All development was on a branch that has not been merged to trunk
  * Medtronic
    * About 25% done with an xliff:doc implementation
    * Had basic TIPP 1.3 implementation working after TM-Europe, but nothing done for 1.4 yet
  * XTM
    * Unknown, presumably not started

### Efforts for LocWorld Paris ###
  * What What tools are involved in the potential demo?
    * Ontram creates package
    * memoQ receives package
    * It would be nice to have a third tool, either XTM or Medtronic's QA tool (fallback)
  * What features of the formats to show?
    * TIPP: xliff:doc, STS file, non-actionable refrence fle
    * xliff:doc
      * Possible: terms, notes, tm matches, qa hits.
      * priorities: TM, QA hits
      * Micah: we could tune priorities for each tool based on role.  eg, not all systems would need to support QA hits for the demo.
      * We will not demo HTML preview.

### Current status of specs ###
  * TIPP
    * Working through 1.4 changes, preliminary draft sent to this; goal to have a real draft available during the first week of Feb.
    * Certain issues causing trouble: attributes, partial completion
      * Chase will bring these up on the list.
  * Xlif:doc
    * Fairly solid but still needs implementation feedback

### Issues that will make implementation more difficult ###
  * Gergely: It would be nice to have docs in a more readable format -- something with a sidebar.  Some discussion of how best to do this follows, but we end up tabling it.
  * We decide to set up a separate mailing list.  Sven will set it up.

### Facilitating Testing ###
  * memoQ: We will be able to download the memoQ builds when they have support.
  * Ontram will set up a test server updated after every 2 week sprint.