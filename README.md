
---

# PixelAlchemy: App Requirements Checklist (MVP V1)

## Purpose and Users
- The app provides a sandbox for experimenting with physics-based element interactions.
- Designed for parents, kids, and homeschooling families.
- The app is engaging for both children and adults.

## Key Features

### Must-Haves (MVP)
- [ ] Interactive 2D game screen for drawing and dropping elements.
- [ ] Physics simulation including gravity, pooling, falling, growth, burning, and explosions.
- [ ] Element customization allowing users to create new elements with properties like density, color, and reactions.
- [ ] Physics customization enabling users to add or modify physics rules.
- [ ] Save state functionality for saving and loading sandbox states.
- [ ] Cross-platform support for Android and iOS using KMP, Jetpack Compose, and SwiftUI.
- [ ] Reset option to revert custom elements and physics to default settings.

### Nice-to-Haves (Future Enhancements)
- [ ] Educational content with facts about elements and physics principles.
- [ ] Additional default elements and physics rules.
- [ ] Tutorials or walkthroughs for using the app.
- [ ] Undo/redo functionality for better control during experimentation.

## User Scenarios
- [ ] User can draw concrete, drop water, and observe it pooling in a dip.
- [ ] User can drop a seed on concrete, add water, and see no growth.
- [ ] User can drop a seed on ground, add water, and observe plant growth.
- [ ] User can apply fire to a plant and observe burning at a defined rate.
- [ ] User can view details about an element by clicking on it.
- [ ] User can edit individual elements in the "Edit Elements" section.
- [ ] User can add new physics rules in the "Edit Physics" section.
- [ ] User can reset all custom elements and physics to defaults.

## Technical Constraints
- [ ] The app supports Android and iOS platforms.
- [ ] The app is built with KMP, Jetpack Compose for Android, and SwiftUI for iOS.
- [ ] The budget is limited to approximately $200 upfront, including the Apple Developer License.
- [ ] The app handles a grid size of up to 100x100 pixels without performance issues.
- [ ] The app stores data locally on the device.
- [ ] The app functions fully offline.

## Non-Functional Requirements
- [ ] The app has an intuitive interface for easy use by kids and parents.
- [ ] The app maintains smooth 2D interactions at 60 FPS.
- [ ] The app has a modern design distinct from *Falling Sand Game*.
- [ ] The app's physics are challenging but consistent.
- [ ] The app's architecture follows DDD and clean architecture principles.

## Next Steps
- [ ] Design the architecture with domain, application, infrastructure, and presentation layers.
- [ ] Implement the MVP features starting with the 2D sandbox and basic physics.
- [ ] Test the app on a small grid before scaling up.
- [ ] Prioritize Android development followed by iOS adaptation.

---
