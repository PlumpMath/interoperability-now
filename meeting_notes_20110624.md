**Attendees**: Sven, Peter, Micah, Chase, and Russ

## Short term goals ##
  * Send specs and manifesto out for beta review by Fri. July 1

## Action items ##
  * Make use cases a google doc for easier collaboration by Fri. June 24 (Russ) - **Done**
  * Update xliff:doc spec based on recent discussions by Mon. June 27 (Micah) - **Done**
  * Update TIP package spec by Wed. June 29 (Chase)
  * Update manifesto based on comments in email threads by Wed. June 29 (Peter)
  * Send sample documents (HTML, Word, and XLIFF?) by Wed. June 29 (Sven)
  * Follow-up with Gabor to try to get his time or see if there is anyone else who might be able to help provide feedback on the level of effort for MemoQ changes by Wed. June 29 (Peter)

## Discussed ##
1) Scope
  * [MB](MB.md): Assume a big part of the demo is to show people what's possible. Should we consider faking parts of the demo?
  * [SA](SA.md): It's important that we accomplish as much as we can, would like to demo as much as possible live
  * [CT](CT.md): I suggest we pick 2 xliff:doc features and have each team validate they can support them and to raise concerns based on that
  * [CT](CT.md): Suggest we do 2 separate 1 hop demos: a) ontram > MemoQ and b) GlobalSight > MemoQ
  * We agreed to make the use case document that Micah drafted a google doc. We will add columns for each team to provide a rough level of effort estimate on support for the step in each scenario as is applicable. Based on that feedback we will try to firm up what will be demoed.
2) Preview
  * [MB](MB.md): For the skeleton files we didn't resolve whether or not we would utilize a text substitution or XML-based approach for content placeholders
  * [SA](SA.md): There will potentially be issues with the text substitution approach (corner cases) so I suggest an XML-based approach
  * [CT](CT.md): Agree
  * We discussed more and settled on adding a new preview element to xliff:doc that will include additional metadata that can be used to generate a richer preview.
  * [SA](SA.md): Current preview status is that we can generate a simple tabular preview from an XLIFF document via XSLT. Next step would be to enhance this to do a richer preview based on the new xliff:doc preview element.
3) Project metadata
  * We discussed and decided to leave this out of the scope of the demo
4) Sample documents
  * We discussed and Sven will provide source (HTML and Word) and XLIFF samples
5) TIP package
  * [CT](CT.md): Almost ready for beta review, just need to add in another paragraph
6) Manifesto
  * [CT](CT.md): My initial comments were aimed at helping to distinguish the goals of this initiative from similar initiatives
  * [PR](PR.md): There was a core list glitch and I wasn't on the email thread. They are archived so I'll review those and update the manifesto based on that.
7) Presentation
  * Micah (95% certain), Gabor, and Sven will be at TM-Europe, Chase may make it, Peter won't be able to be there
  * XLIFF symposium is right before TM-Europe
  * Alan Melby will be presenting his work too
8) Logistics
  * We will aim for end of next week to get the beta review out
  * Peter will follow-up with Gabor to try to get his time or see if there is anyone else who might be able to help provide feedback on the level of effort for Kilgray changes