#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
Hoarding-26.1.2 开发控制台
现代化 GUI · JDK 25 自动配置 · 实时日志输出
"""

import tkinter as tk
from tkinter import ttk, scrolledtext
import subprocess
import threading
import os
import sys
import time
from pathlib import Path


# ──────────────────────────────────────────────
# 主题配色方案
# ──────────────────────────────────────────────

THEMES = {
    "light": {
        "bg": "#f5f5f5",
        "fg": "#1a1a1a",
        "frame_bg": "#ffffff",
        "frame_border": "#dcdcdc",
        "accent": "#0078d4",
        "accent_hover": "#106ebe",
        "success": "#107c10",
        "success_hover": "#0b6a0b",
        "warning": "#d83b01",
        "warning_hover": "#b93200",
        "danger": "#d32f2f",
        "danger_hover": "#b71c1c",
        "info_bg": "#f0f6fc",
        "info_fg": "#004578",
        "log_bg": "#fafafa",
        "log_fg": "#1a1a1a",
        "status_bg": "#e8e8e8",
        "button_fg": "#ffffff",
        "title_bg": "#0078d4",
        "title_fg": "#ffffff",
        "separator": "#dcdcdc",
    },
    "dark": {
        "bg": "#1e1e1e",
        "fg": "#d4d4d4",
        "frame_bg": "#252526",
        "frame_border": "#3c3c3c",
        "accent": "#0098ff",
        "accent_hover": "#1ea7ff",
        "success": "#3fb950",
        "success_hover": "#2ea043",
        "warning": "#d29922",
        "warning_hover": "#bb8009",
        "danger": "#f85149",
        "danger_hover": "#da3633",
        "info_bg": "#1a3a5c",
        "info_fg": "#58a6ff",
        "log_bg": "#1a1a1a",
        "log_fg": "#d4d4d4",
        "status_bg": "#2d2d2d",
        "button_fg": "#ffffff",
        "title_bg": "#0078d4",
        "title_fg": "#ffffff",
        "separator": "#3c3c3c",
    },
}

# ──────────────────────────────────────────────
# 彩色按钮样式工厂
# ──────────────────────────────────────────────

class ModernButton(ttk.Frame):
    """自定义扁平按钮，支持主题色"""

    def __init__(self, parent, text, color_key="accent", command=None, width=14):
        super().__init__(parent)
        self.command = command
        self.color_key = color_key
        self.width = width
        self._theme = None

        self._btn = tk.Label(
            self,
            text=text,
            anchor="center",
            padx=4,
            pady=6,
            cursor="hand2",
            font=("Segoe UI", 10, "bold"),
            width=width,
        )
        self._btn.pack(fill="both", expand=True)

        self._btn.bind("<Button-1>", self._on_click)
        self._btn.bind("<Enter>", self._on_enter)
        self._btn.bind("<Leave>", self._on_leave)

    def apply_theme(self, theme):
        self._theme = theme
        colors = THEMES[theme]
        normal = colors.get(self.color_key, colors["accent"])
        self._normal_bg = normal
        self._hover_bg = colors.get(f"{self.color_key}_hover", normal)
        self._btn.config(
            bg=normal,
            fg=colors["button_fg"],
            relief="flat",
            bd=0,
            highlightthickness=0,
        )

    def _on_enter(self, event):
        if self._theme:
            self._btn.config(bg=self._hover_bg)

    def _on_leave(self, event):
        if self._theme:
            self._btn.config(bg=self._normal_bg)

    def _on_click(self, event):
        if self.command:
            self.command()

    def set_enabled(self, enabled):
        state = "normal" if enabled else "disabled"
        self._btn.config(state=state)
        if self._theme:
            colors = THEMES[self._theme]
            if enabled:
                self._btn.config(bg=self._normal_bg, fg=colors["button_fg"])
            else:
                self._btn.config(bg=colors["frame_bg"], fg=colors["separator"])


# ──────────────────────────────────────────────
# 主控制面板
# ──────────────────────────────────────────────

class HoardingControlPanel:
    def __init__(self, root):
        self.root = root
        self.root.title("Hoarding-26.1.2 开发控制台")
        self.root.geometry("860x640")
        self.root.minsize(700, 500)

        # 当前运行进程
        self.process = None
        self.running = False

        # JDK 配置
        self.java_home = r"C:\Java\jdk-25"
        self.project_dir = os.path.dirname(os.path.abspath(__file__))

        # 主题（默认浅色）
        self._current_theme = tk.StringVar(value="light")

        # 图标（使用 Unicode / 无外部依赖）
        self._setup_window_icon()
        self._verify_jdk()
        self.setup_ui()
        self.apply_theme("light")

        # 窗口关闭时终止子进程
        self.root.protocol("WM_DELETE_WINDOW", self._on_close)

    # ── JDK 验证 ──────────────────────────────

    def _verify_jdk(self):
        jdk_path = Path(self.java_home)
        javac = jdk_path / "bin" / "javac.exe"
        java = jdk_path / "bin" / "java.exe"
        if not jdk_path.is_dir():
            self._jdk_valid = False
            self._jdk_msg = f"⚠ JDK 目录不存在: {self.java_home}"
        elif not javac.is_file():
            self._jdk_valid = False
            self._jdk_msg = f"⚠ 未找到 javac.exe，请检查 JDK 安装"
        else:
            self._jdk_valid = True
            self._jdk_msg = f"✓ JDK 25 — {self.java_home}"

    # ── 窗口图标（用 tkinter 内置图标）───────

    def _setup_window_icon(self):
        try:
            # Windows 上使用默认的 python 图标
            if sys.platform == "win32":
                try:
                    self.root.iconbitmap(default="")
                except Exception:
                    pass
        except Exception:
            pass

    # ── UI 构建 ──────────────────────────────

    def setup_ui(self):
        # 根容器
        self._main = tk.Frame(self.root)
        self._main.pack(fill="both", expand=True)

        # 让 ttk.Frame 支持背景色覆写
        style = ttk.Style()
        style.layout("TFrame", [("Frame.border", {"children": [("Frame.body", {})], "sticky": "nsew"})])

        # ══════════ 顶栏：标题 + JDK ══════════
        self._header = tk.Frame(self._main, height=56)
        self._header.pack(fill="x", side="top")
        self._header.pack_propagate(False)

        # 标题 + 主题切换
        header_left = tk.Frame(self._header)
        header_left.pack(side="left", fill="both", expand=True, padx=(16, 0))

        self._title_label = tk.Label(
            header_left,
            text="⚙ Hoarding-26.1.2 开发控制台",
            font=("Segoe UI", 14, "bold"),
            anchor="w",
        )
        self._title_label.pack(side="top", anchor="w", pady=(6, 0))

        self._jdk_label = tk.Label(
            header_left,
            text=self._jdk_msg,
            font=("Segoe UI", 9),
            anchor="w",
        )
        self._jdk_label.pack(side="top", anchor="w")

        # 主题切换按钮
        header_right = tk.Frame(self._header)
        header_right.pack(side="right", padx=(0, 12))

        self._theme_btn = tk.Label(
            header_right,
            text="🌙 深色",
            font=("Segoe UI", 9),
            cursor="hand2",
            padx=8,
            pady=2,
        )
        self._theme_btn.pack()
        self._theme_btn.bind("<Button-1>", self._toggle_theme)

        # ══════════ 按钮区域 ════════════════
        self._btn_frame = tk.Frame(self._main)
        self._btn_frame.pack(fill="x", padx=12, pady=(8, 4))

        btn_specs = [
            ("▶ 启动客户端", "success", lambda: self.run_gradle("runClient")),
            ("⚡ DataGen", "success", lambda: self.run_gradle("runData")),
            ("🔨 构建", "accent", lambda: self.run_gradle("build")),
        ]
        btn_specs2 = [
            ("☕ 编译", "accent", lambda: self.run_gradle("compileJava")),
            ("🧹 清理", "warning", lambda: self.run_gradle("clean")),
            ("🛑 停止", "danger", self.stop_process),
        ]

        self._buttons = []
        row1 = tk.Frame(self._btn_frame)
        row1.pack(fill="x", pady=2)
        for text, color, cmd in btn_specs:
            btn = ModernButton(row1, text=text, color_key=color, command=cmd)
            btn.pack(side="left", padx=4, ipady=2)
            self._buttons.append(btn)

        row2 = tk.Frame(self._btn_frame)
        row2.pack(fill="x", pady=2)
        for text, color, cmd in btn_specs2:
            btn = ModernButton(row2, text=text, color_key=color, command=cmd)
            btn.pack(side="left", padx=4, ipady=2)
            self._buttons.append(btn)

        # ══════════ 日志区域 ════════════════
        log_frame = tk.Frame(self._main)
        log_frame.pack(fill="both", expand=True, padx=12, pady=(4, 6))

        self._log_text = tk.Text(
            log_frame,
            wrap="word",
            font=("Cascadia Code", 10, "normal"),
            relief="flat",
            bd=0,
            padx=8,
            pady=6,
            highlightthickness=1,
            highlightbackground="#dcdcdc",
            undo=False,
        )
        self._log_text.pack(side="left", fill="both", expand=True)

        log_scroll = tk.Scrollbar(log_frame, orient="vertical", command=self._log_text.yview)
        log_scroll.pack(side="right", fill="y")
        self._log_text.config(yscrollcommand=log_scroll.set)

        # 右键菜单
        self._log_menu = tk.Menu(self._log_text, tearoff=0)
        self._log_menu.add_command(label="复制", command=self._copy_selected, accelerator="Ctrl+C")
        self._log_menu.add_separator()
        self._log_menu.add_command(label="清空日志", command=self._clear_log)
        self._log_text.bind("<Button-3>", self._show_log_menu)
        self._log_text.bind("<Control-c>", lambda e: self._copy_selected())

        # ══════════ 状态栏 ═════════════════
        self._status_frame = tk.Frame(self._main, height=28)
        self._status_frame.pack(fill="x", side="bottom")
        self._status_frame.pack_propagate(False)

        self._status_label = tk.Label(
            self._status_frame,
            text="就绪",
            font=("Segoe UI", 9),
            anchor="w",
            padx=12,
        )
        self._status_label.pack(side="left", fill="both", expand=True)

        self._task_label = tk.Label(
            self._status_frame,
            text="",
            font=("Segoe UI", 9),
            anchor="e",
            padx=12,
        )
        self._task_label.pack(side="right")

    # ── 主题应用 ──────────────────────────────

    def apply_theme(self, theme_name):
        colors = THEMES[theme_name]
        self._current_theme.set(theme_name)

        # 窗口背景
        self.root.config(bg=colors["bg"])
        self._main.config(bg=colors["bg"])

        # 顶栏
        self._header.config(bg=colors["title_bg"])
        self._title_label.config(bg=colors["title_bg"], fg=colors["title_fg"])
        self._jdk_label.config(bg=colors["title_bg"], fg=colors["title_fg"])
        header_left = self._header.winfo_children()[0]
        header_left.config(bg=colors["title_bg"])
        header_right = self._header.winfo_children()[1]
        header_right.config(bg=colors["title_bg"])
        self._theme_btn.config(bg=colors["title_bg"], fg=colors["title_fg"])

        # 按钮区域
        self._btn_frame.config(bg=colors["bg"])
        for child in self._btn_frame.winfo_children():
            child.config(bg=colors["bg"])
            for grandchild in child.winfo_children():
                grandchild.apply_theme(theme_name)

        # 日志区域
        log_frame = self._log_text.master
        log_frame.config(bg=colors["bg"])
        self._log_text.config(
            bg=colors["log_bg"],
            fg=colors["log_fg"],
            highlightbackground=colors["frame_border"],
            insertbackground=colors["fg"],
        )

        # 状态栏
        self._status_frame.config(bg=colors["status_bg"])
        self._status_label.config(bg=colors["status_bg"], fg=colors["fg"])
        self._task_label.config(bg=colors["status_bg"], fg=colors["fg"])

        # 菜单
        self._log_menu.config(bg=colors["frame_bg"], fg=colors["fg"])

        # 滚动条颜色（近似）
        style = ttk.Style()
        style.theme_use("clam")
        style.configure("Vertical.TScrollbar",
                        background=colors["frame_border"],
                        troughcolor=colors["bg"],
                        arrowcolor=colors["fg"])

        # 切换按钮文本
        if theme_name == "dark":
            self._theme_btn.config(text="☀️ 浅色")
        else:
            self._theme_btn.config(text="🌙 深色")

    def _toggle_theme(self, event=None):
        current = self._current_theme.get()
        new = "dark" if current == "light" else "light"
        self.apply_theme(new)

    # ── 核心功能 ──────────────────────────────

    def run_gradle(self, task):
        if self.running:
            self.log("⚠ 已有任务正在运行，请等待完成或手动停止")
            return

        # JDK 检查
        if not self._jdk_valid:
            self.log("=" * 50)
            self.log(f"❌ {self._jdk_msg}")
            self.log("请在设置中配置正确的 JAVA_HOME 路径")
            self.log("=" * 50)
            return

        self.running = True
        self._set_buttons_enabled(False)
        self._update_status("运行中", f"▶ {task}")

        def run():
            env = os.environ.copy()
            env["JAVA_HOME"] = self.java_home
            env["PATH"] = f"{self.java_home}\\bin;{env.get('PATH', '')}"

            cmd = ["cmd", "/c", f"gradlew.bat {task}"]

            self.log("=" * 50)
            self.log(f"🔄 开始任务: {task}")
            self.log(f"📂 工作目录: {self.project_dir}")
            self.log(f"☕ JAVA_HOME: {self.java_home}")
            self.log("-" * 50)

            start_time = time.time()

            try:
                self.process = subprocess.Popen(
                    cmd,
                    cwd=self.project_dir,
                    stdout=subprocess.PIPE,
                    stderr=subprocess.STDOUT,
                    env=env,
                    text=True,
                    bufsize=1,
                    encoding="utf-8",
                    errors="replace",
                    creationflags=subprocess.CREATE_NO_WINDOW,
                )

                for line in iter(self.process.stdout.readline, ""):
                    self.log(line.rstrip())

                self.process.wait()
                elapsed = time.time() - start_time
                code = self.process.returncode

                if code == 0:
                    self.log("-" * 50)
                    self.log(f"✅ 任务成功完成 ({elapsed:.1f} 秒)")
                else:
                    self.log("-" * 50)
                    self.log(f"❌ 任务失败 (退出码: {code}, 耗时: {elapsed:.1f} 秒)")

                self.log("=" * 50)

            except FileNotFoundError:
                self.log("❌ 未找到 gradlew.bat，请确认项目结构正确")
            except Exception as e:
                self.log(f"❌ 执行异常: {e}")
            finally:
                self.process = None
                self.running = False
                self.root.after(0, self._on_task_done)

        threading.Thread(target=run, daemon=True).start()

    def stop_process(self):
        if self.process and self.process.poll() is None:
            self.log("🛑 正在终止任务...")
            try:
                self.process.terminate()
                # 给进程一点时间，然后强制结束
                def force_kill():
                    if self.process and self.process.poll() is None:
                        self.process.kill()
                        self.log("💀 进程已强制终止")
                threading.Timer(3.0, force_kill).start()
            except Exception as e:
                self.log(f"⚠ 终止进程时出错: {e}")
        else:
            self.log("ℹ 当前没有正在运行的任务")

    def _on_task_done(self):
        self._set_buttons_enabled(True)
        self._update_status("就绪", "")
        # 停止按钮恢复
        for btn in self._buttons:
            if "停止" in btn._btn.cget("text"):
                btn.set_enabled(True)

    def _set_buttons_enabled(self, enabled):
        for btn in self._buttons:
            btn.set_enabled(enabled)
        # 停止按钮始终可用
        for btn in self._buttons:
            if "停止" in btn._btn.cget("text"):
                btn.set_enabled(True)

    def _update_status(self, status, task=""):
        self._status_label.config(text=f"  状态: {status}")
        self._task_label.config(text=task)

    # ── 日志操作 ──────────────────────────────

    def log(self, text):
        """向日志区域追加文本（线程安全）"""
        def _append():
            self._log_text.insert(tk.END, text + "\n")
            self._log_text.see(tk.END)
        self.root.after(0, _append)

    def _copy_selected(self):
        try:
            selected = self._log_text.get(tk.SEL_FIRST, tk.SEL_LAST)
            self.root.clipboard_clear()
            self.root.clipboard_append(selected)
        except tk.TclError:
            pass  # 没有选中内容

    def _clear_log(self):
        self._log_text.delete(1.0, tk.END)

    def _show_log_menu(self, event):
        try:
            self._log_menu.tk_popup(event.x_root, event.y_root)
        finally:
            self._log_menu.grab_release()

    # ── 窗口关闭 ──────────────────────────────

    def _on_close(self):
        if self.process and self.process.poll() is None:
            self.log("🛑 正在终止运行中的任务...")
            self.process.terminate()
        self.root.destroy()


# ──────────────────────────────────────────────
# 入口
# ──────────────────────────────────────────────

def main():
    root = tk.Tk()
    app = HoardingControlPanel(root)
    root.mainloop()


if __name__ == "__main__":
    main()
