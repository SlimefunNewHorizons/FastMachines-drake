<div align="center">

  <img src="https://raw.githubusercontent.com/SlimefunNewHorizons/FastMachines-drake/main/banner.svg" alt="FastMachines banner" width="920" />

# FastMachines · Drake edition

**Manual crafting machines for Slimefun4 that spend energy, craft every shapeless recipe and support bulk crafting.**

<p>
  <a href="https://github.com/SlimefunNewHorizons/FastMachines-drake"><img src="https://img.shields.io/badge/GitHub-FastMachines-drake-181717?style=for-the-badge&logo=github" alt="GitHub"/></a>
  <img src="https://img.shields.io/badge/Slimefun4-Drake_Edition-22C55E?style=for-the-badge" alt="Slimefun4"/>
  <img src="https://img.shields.io/badge/Paper-1.21.11-38BDF8?style=for-the-badge&logo=minecraft&logoColor=white" alt="Paper 1.21.11"/>
  <img src="https://img.shields.io/badge/Java-21-F89820?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 21"/>
  <img src="https://img.shields.io/badge/License-GPL--3.0-blue?style=for-the-badge" alt="GPL-3.0"/>
</p>

</div>

> ### 🏰 Join the official DrakesCraft community
> * 🎮 **Server IP**: `mc.drakescraft.cl` *(Java 1.21.11 & Bedrock)*
> * 💬 **Discord**: [discord.gg/drakescraft](https://discord.gg/rv3vtXZTk7)
> * 🌐 **Website & guides**: [web.drakescraft.cl](https://web.drakescraft.cl)

## What is it

Manual crafting machines for Slimefun4 that spend energy, craft every shapeless recipe and support bulk crafting.

## Status in DrakesCraft

- Runs on Dallas today as `FastMachines-11.0-Drake-1.21.1-SNAPSHOT.jar`.
- Extracted from the legacy `drakes-slimefun-labs` monorepo (October 2026) into its own repository, with the full source tree.
- The CI of the organization (verify + security) runs on every push: see the reusable workflows in
  [`SlimefunNewHorizons/.github`](https://github.com/SlimefunNewHorizons/.github).

## Build

```bash
./gradlew build
```

Java 21 is required. Place the resulting jar in the server's `plugins/` folder next to the Slimefun core
([Slimefun4-Drake](https://github.com/SlimefunNewHorizons/Slimefun4-Drake)).

Dependencies are resolved from the Drake Maven repository, <https://maven.drakescraft.cl> (GitHub Pages of
[`SlimefunNewHorizons/maven-repo`](https://github.com/SlimefunNewHorizons/maven-repo)):

| Line | Core | Java |
|---|---|---|
| 1.21.11 (production) | `slimefun-core 11.0-Drake-1.21.11-SNAPSHOT` | 21 |
| Universal 26.x (Paper 26.2) | `slimefun-core 11.0-Universal-26.x-SNAPSHOT` + `dough-core 1.3.1-Universal-26.x-SNAPSHOT` | 25 |

To use an already built jar on the 26.x line, port it with `scripts/portar_addons.py <input> <output>` from `ai-hub`
(relocates the Dallas fork package to the universal one and raises `api-version` to 1.21).

## Upstream & license

Extracted from FinalTECH (credit: Final_Root) and maintained by GuizhanCraft.
Original project: <https://github.com/GuizhanCraft/FastMachines>.
This fork is distributed under the same **GPL-3.0** (see [`LICENSE`](LICENSE)); upstream authorship is
preserved in [`docs/UPSTREAM_ATTRIBUTION.md`](docs/UPSTREAM_ATTRIBUTION.md). Maintained by
[JackStar6677-1](https://github.com/JackStar6677-1) under [DrakesCraft Labs](https://github.com/SlimefunNewHorizons).

---

## Original README

# FastMachines

[English](README.md) | [中文](README.zh_CN.md)

This Slimefun addon extracts the manual machines from FinalTECH and made some changes to put them into a separate addon.  
Fast machines are manual crafters that cost energy to run and can craft items with all shapeless recipes and support bulk crafting.

Credit: Final_Root

## Download

Download from (either one is fine):

- [Blob builds](https://blob.build/project/FastMachines)
- [Guizhan Builds![Build Status](https://builds.guizhanss.com/ybw0014/FastMachines/master/badge.svg)](https://builds.guizhanss.com/ybw0014/FastMachines/master)

## Supported plugins

- [SlimefunTranslation](https://github.com/ybw0014/SlimefunTranslation): per player localization.
- [InfinityExpansion](https://github.com/Mooy1/InfinityExpansion): extra fast machines for Infinity Expansion.
- [SlimeFrame](https://github.com/VoperAD/SlimeFrame): extra fast machines for SlimeFrame.
- [InfinityExpansion2](https://github.com/ybw0014/InfinityExpansion2): extra fast machines for Infinity Expansion 2.

## Thanks

Thanks to anyone who helped me during the development of this addon.

Thanks to [minecraft-heads.com](https://minecraft-heads.com/) for the heads used in this addon.

[![](https://minecraft-heads.com/images/banners/minecraft-heads_fullbanner_468x60.png)](https://minecraft-heads.com/)
